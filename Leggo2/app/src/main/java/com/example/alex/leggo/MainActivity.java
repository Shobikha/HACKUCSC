package com.example.alex.leggo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton button = (ImageButton) findViewById(R.id.event);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                StartEvent();
            }
        });
    }

    public void StartEvent() {
        Intent myEvent = new Intent(getApplicationContext(), EventActivity.class);
        startActivity(myEvent);
    }
}
