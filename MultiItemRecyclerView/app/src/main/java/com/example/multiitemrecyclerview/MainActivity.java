package com.example.multiitemrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // LinearLayoutManager is a type of LayoutManager that arranges
        // items in a linear vertical or horizontal scrolling list.

        recyclerView.setLayoutManager(layoutManager);
        //This line sets the LayoutManager for the RecyclerView.
        //By setting the LinearLayoutManager, the RecyclerView will display its items in a vertical list.

        List<Items> itemClasses = new ArrayList<>();
        //List<Items> itemClasses = new ArrayList<>();:
        // This line creates a new ArrayList named itemClasses to hold the data for the RecyclerView.
        itemClasses.add(new Items(Items.TITLE, "ANIMALS"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.fox, "Fox"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.turtle, "Turtle"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.rihnosoure, "Rihno"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.bear, "Bear"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.beef, "Beef"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.giraffe, "Giraffe"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.turtle, "Turtle"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.monkey, "Monkey"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.tiger, "Tiger"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.dog, "Dog"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.deer, "Deer"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.zebra, "Zebra"));
        itemClasses.add(new Items(Items.TITLE, "FRUITS"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.blueberries, "Blueberries"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.strawberries, "Strawberries"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.mango, "Mango"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.pineapple, "Pineapple"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.orange, "Orange"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.kiwi, "Kiwi"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.cherries, "Cherries"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.grapes, "Grapes"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.dragonfruit, "DragonFruit"));
        itemClasses.add(new Items(Items.ITEM, R.drawable.greenapple, "Green Apple"));

        MainmultiAdapter adapter = new MainmultiAdapter(itemClasses);
        recyclerView.setAdapter(adapter);
       // MainmultiAdapter adapter = new MainmultiAdapter(itemClasses):
        // An instance of MainmultiAdapter is created, passing the itemClasses list as the dataset.
      //  recyclerView.setAdapter(adapter): The adapter is set on the RecyclerView.
        //  The adapter is responsible for creating ViewHolders for the items in the dataset and binding data to them.
    }
}
