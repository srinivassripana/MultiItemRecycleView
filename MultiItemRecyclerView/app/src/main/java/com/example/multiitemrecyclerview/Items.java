package com.example.multiitemrecyclerview;

public class Items {
    public static final int TITLE = 1;
    public static final int ITEM = 2;

    private int typeOfLayout;
    private int imageResource;
    private String name;
    private boolean isSelected; // New field to track selection state

    public Items(int typeOfLayout, String name) {
        this.typeOfLayout = typeOfLayout;
        this.name = name;
    }

    public Items(int typeOfLayout, int imageResource, String name) {
        this.typeOfLayout = typeOfLayout;
        this.imageResource = imageResource;
        this.name = name;
    }

    public int getLayoutType() {
        return typeOfLayout;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

