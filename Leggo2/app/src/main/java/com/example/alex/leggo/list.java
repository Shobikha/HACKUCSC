package com.example.alex.leggo;

/**
 * Created by alex on 1/21/17.
 */

public class list {

    private class Node
    {
        String name;
        String date;
        String desc;
        Node prev;
        Node next;

        //constructor
        Node(String name, String date, String desc) {
            this.name = name;
            this.date = date;
            this.desc = desc;
            prev = null;
            next = null;
        }
    }


    //Variables for List
    private Node front; 	//head of the list
    private Node back; 		//tail of the list
    private Node cursor;	//current node ofthe list
    private int length;		//length of the list
    private int index;		//index of the cursor

    String[] itemList = {"fieldTrips", "game", "music", "networking", "photography", "program", "sports", "all"};

    //creates a new empty list.
    public list() {
        front = null;
        back = null;
        cursor = null;
        length = 0;
        index = -1;
    }

    public String getItem(int i){
        return itemList[i];
    }

    public int length(){
        return length;
    }

    public int index() {
        return index;
    }

    public Node getHead(){
        return front;
    }

    public Node getCurr(){
        return cursor;
    }

    public Node getBack(){
        return back;
    }

    // Inserts new element after cursor.
    // Pre: length()>0, index()>=0
    public void insertAfter(String name, String date, String desc)
    {
        Node node = new Node(name, date, desc);
       if(length() > 0 && index >= 0) {
            if(index() == length() -1) {
                cursor.next = node;
                node.prev = cursor;
                back = node;
            }
            else {
                node.prev = cursor;
                node.next = cursor.next;
                cursor.next.prev = node;
                cursor.next = node;
            }
            length++;
        }
    }

    // Deletes the front element. Pre: length()>0
    public void deleteFront()
    {
      {
            if(length() > 1) {
                if(cursor.equals(front)){
                    cursor = front.next;
                    index++;
                }
                front = front.next;
                front.prev = null;
                index--;
                length--;
            }
            else{
                clear();
            }
        }
    }

    // Deletes the back element. Pre: length()>0
    public void deleteBack()
    {
         {
            if(length() > 1) {
                if(cursor.equals(back)){
                    cursor = back.prev;
                    index--;
                }
                back = back.prev;
                back.next = null;
                length--;
            }
            else{
                clear();
            }
        }
    }

    // Deletes cursor element, making cursor undefined.
    // Pre: length()>0, index()>=0
    public void delete()
    {
        if(index() == 0) {
            deleteFront();
            cursor = null;
        }
        else if(index() == length() - 1) {
            deleteBack();
            cursor = null;
        }
        else if(index() > 0 && index() < length() - 1)
        {
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = null;
        }
        length--;
        index = -1;
    }

    public void clear()
    {
        front = null;
        back = null;
        cursor = null;
        length = 0;
        index = -1;
    }

    public void moveFront()
    {
        if(length() > 0) {
            cursor = front;
            index = 0;
        }
    }

    public void moveBack()
    {
        if(length() > 0) {
            cursor = back;
            index = length() - 1;
        }
    }


    public void movePrev()
    {
        if(index() > 0 && cursor != null) {
            cursor = cursor.prev;
            index --;
        }
        else if(index() == 0 && cursor != null) {
            cursor = null;
            index = -1;
        }
    }


    public void moveNext()
    {
        if(cursor != null && index() < length() - 1) {
            cursor = cursor.next;
            index++;
        }
        else if( index() == length() - 1 && cursor != null) {
            cursor = null;
            index = -1;
        }
    }

}
