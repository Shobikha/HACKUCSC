package com.example.alex.leggo;

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Harsh on 1/21/2017.
 */

public class User {

    FirebaseDatabase database;
    DatabaseReference myRef;

    String key, firstName, lastName, age;
    public User(){
        this.key = "555";
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }
    public User(String firstName, String lastName, String age){
        this.key = "555";
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

    public void setName(String firstName, String lastName){
        Log.i("HEY", "" + myRef.child("people"));
    }

    public void setAge(String age){
        this.age = age;
    }

    String getFirstName(){
        return this.firstName;
    }

    String getLastName(){
        return this.lastName;
    }
    String getAge(){
        return this.age;
    }

}
