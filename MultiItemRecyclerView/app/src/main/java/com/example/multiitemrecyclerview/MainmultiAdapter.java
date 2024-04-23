package com.example.multiitemrecyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainmultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Items> itemsList;

    public MainmultiAdapter(List<Items> itemsList) {
        this.itemsList = itemsList;
    } //The AdapterClass constructor takes a
    // List<ItemClass> as a parameter, representing the data set to be displayed in the RecyclerView.

    @Override
    public int getItemViewType(int position) {
        // This method returns the view type of the item at the specified position.
        //       It uses the getLayoutType() method of ItemClass to determine the view type.
        return itemsList.get(position).getLayoutType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This method is responsible for creating a new ViewHolder instance for each item in the RecyclerView.
        //It inflates the appropriate layout based on the view type (LayoutOne or LayoutTwo).
        //It returns a new instance of the corresponding ViewHolder.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == Items.TITLE) {
            view = inflater.inflate(R.layout.title_view, parent, false);
            return new LayoutOneViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.row_view, parent, false);
            return new LayoutTwoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Items item = itemsList.get(position);

        if (holder instanceof LayoutOneViewHolder) {
            LayoutOneViewHolder titleViewHolder = (LayoutOneViewHolder) holder;
            titleViewHolder.bind(item);
        } else if (holder instanceof LayoutTwoViewHolder) {
            LayoutTwoViewHolder itemViewHolder = (LayoutTwoViewHolder) holder;
            itemViewHolder.bind(item);

            // Show/hide tick mark based on selection state
            if (item.isSelected()) {
                itemViewHolder.showTickMark();
            } else {
                itemViewHolder.hideTickMark();
            }

            // Implement click listener to toggle selection state
            itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.setSelected(!item.isSelected());
                    notifyItemChanged(position);
                }
            });
        }
    }

    //This method is responsible for binding data to the ViewHolder.
    //It gets the ItemClass object at the specified position from the itemClasses list.
    //It checks the instance of the ViewHolder and binds data accordingly.
    //For LayoutOneViewHolder, it sets the text to the TextView.
    //For LayoutTwoViewHolder, it sets the image resource to the ImageView and text to the TextView.
    @Override
    public int getItemCount() {

        return itemsList.size();
    }

    static class LayoutOneViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LayoutOneViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title_view);
        }

        public void bind(Items itemClass) {
            textView.setText(itemClass.getName());
        }
    }

    static class LayoutTwoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private ImageView tickMark; // New field for the tick mark

        public LayoutTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_views);
            textView = itemView.findViewById(R.id.text_view);
            tickMark = itemView.findViewById(R.id.tick_mark); // Initialize tick mark
        }

        public void bind(Items item) {
            imageView.setImageResource(item.getImageResource());
            textView.setText(item.getName());
        }

        public void showTickMark() {
            tickMark.setVisibility(View.VISIBLE);
        }

        public void hideTickMark() {
            tickMark.setVisibility(View.GONE);
        }
    }
}

