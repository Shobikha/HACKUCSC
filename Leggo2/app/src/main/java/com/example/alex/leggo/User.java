package com.example.alex.leggo;

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Harsh on 1/21/2017.
 */

public class User {

    String uid, firstName, lastName, age, email;
    public User(){
        //Deafult Constructor
    }

    public void setUid(String uid){
        this.uid = uid;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAge(String age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public String getAge(){
        return this.age;
    }
    public String getEmail(){
        return this.email;
    }

}
