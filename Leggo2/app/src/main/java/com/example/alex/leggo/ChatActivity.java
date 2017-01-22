package com.example.alex.leggo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.text.NumberFormat.getInstance;

public class ChatActivity extends AppCompatActivity {
    private DatabaseReference root;
    private TextView recieve_msg;
    private EditText edit_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
         Button send_msg = (Button) findViewById(R.id.send);
         edit_msg = (EditText) findViewById(R.id.message);
         recieve_msg = (TextView) findViewById(R.id.recieve);

        final String userName, roomName;
        userName = getIntent().getExtras().get("user_name").toString();
        roomName = getIntent().getExtras().get("room_name").toString();
        setTitle(" Room - " + roomName);
         root = FirebaseDatabase.getInstance().getReferenceFromUrl(Data.URL).child(roomName);
        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> map = new HashMap<String, Object>();
                String temp_key = root.push().getKey();
                root.updateChildren(map);
                DatabaseReference message_root = root.child(temp_key);
                Map<String, Object> display = new HashMap<String, Object>();

                display.put("name", userName);
                display.put("msg", edit_msg.getText().toString());

                message_root.updateChildren(display);
            }
        });

        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_chat_conversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //append_chat_conversation(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private String chat_msg, chat_user_name;
    private void append_chat_conversation(DataSnapshot dataSnapshot) {
        /*Iterator i = dataSnapshot.getChildrenCount();

        while (i.hasNext()) {
            chat_user_name = ((DataSnapshot)i.next()).getValue().toString();
            chat_msg = (String) ((DataSnapshot)i.next()).getValue();

            recieve_msg.append(chat_user_name + ": " + chat_msg + "\n ");
        }
        */
        /*for(DataSnapshot child : dataSnapshot.getChildren()){

            chat_user_name = child.getValue().toString();
            chat_msg = (String) child.getValue();

            recieve_msg.append(chat_user_name + ": " + chat_msg + "\n ");

        }*/

        chat_user_name = dataSnapshot.child("name").getValue().toString();
        chat_msg = dataSnapshot.child("msg").getValue().toString();

        recieve_msg.append(chat_user_name + ": " + chat_msg + "\n ");

    }
}
