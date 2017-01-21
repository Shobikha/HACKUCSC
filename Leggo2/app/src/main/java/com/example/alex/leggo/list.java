package com.example.alex.leggo;

/**
 * Created by alex on 1/21/17.
 */

public class list {
    String[] itemList = {"program", "music", "game", "all", "sports", "fieldTrips", "networking", "photography"};
    String[] programming = {"Web Development", "Python"};
    String[] networking = {"Network Security"};
    private int length;
    private int curr;
    private int[] index = {2, 0, 0, 0, 0, 0, 1, 0};

    public list () {
       length = itemList.length;
        curr = 0;
    }
    public boolean endOfList(list l) {
        return l.getIndex() == curr;


    }

    public int getIndex() {
        return index.length;
    }
    public String getItem(int i) {
        return itemList[i];
    }
    public int length() {
        return length;
    }
}
