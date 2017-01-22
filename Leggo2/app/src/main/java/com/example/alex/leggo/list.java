package com.example.alex.leggo;

/**
 * Created by alex on 1/21/17.
 */

public class list {

    class Node{
        String name;
        String date;
        String desc;
        Node next;

        public Node(){
            //default constructor
        }
    }


    String[] itemList = {"fieldTrips", "game", "music", "networking", "photography", "program", "sports", "all"};
    private int length;
    private Node back;
    private Node head;
    private Node curr;

    public list () {
        length = 0;
        head = null;
        back = null;
        curr = null;
    }

    public Node getHead(){
        return head;
    }

    public Node getCurr(){
        return curr;
    }

    public Node getBack(){
        return back;
    }

    public void add(String name, String date, String desc){
        Node N = new Node();

        if(head == null){
            N.name = name;
            N.date = date;
            N.desc = desc;
            N.next = null;
            head = N;
            back = N;
            curr = N;
            length++;
        }
        else{
            N.name = name;
            N.date = date;
            N.desc = desc;
            N.next = null;
            back.next = N;
            back = N;
            curr = N;
            length++;
        }
    }

    public void delete(Node N){
        
    }
    public boolean endOfList(list l) {


        return true;
    }

    public String getItem(int i) {
        return itemList[i];
    }
    public int length() {
        return length;
    }
}
