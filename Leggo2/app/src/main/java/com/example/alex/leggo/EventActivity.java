package com.example.alex.leggo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                boolean defaultValue = false;
////                boolean yourValue = getIntent().getBooleanExtra("program", defaultValue);
//            }
//        });
        TextView t=(TextView)findViewById(R.id.eventList);

        boolean isProgramChecked = getIntent().getExtras().getBoolean("program");
            if(isProgramChecked) {
                t.setText("Web Design for Beginners, \n" +
                        "coding a website from scratch \n" +
                        "intro to programming: writing Python");
            } else {
                t.setText("");
            }
    }

}
