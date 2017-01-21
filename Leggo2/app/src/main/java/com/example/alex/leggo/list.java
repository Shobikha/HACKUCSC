package com.example.alex.leggo;

/**
 * Created by alex on 1/21/17.
 */

public class list {
    String[] itemList = {"program", "music", "game", "all", "sports", "fieldTrips", "networking", "photography"};
    int length;
    public list () {
       length = itemList.length;
    }
    public String getItem(int i) {
        return itemList[i];
    }
    public int length() {
        return length;
    }
}
