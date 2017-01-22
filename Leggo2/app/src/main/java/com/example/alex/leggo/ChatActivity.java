package com.example.alex.leggo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Button send_msg = (Button) findViewById(R.id.send);
        EditText edit_msg = (EditText) findViewById(R.id.editText);
        TextView recieve_msg = (TextView) findViewById(R.id.recieve);

    }
}
