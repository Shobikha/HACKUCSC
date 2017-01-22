package com.example.alex.leggo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private ImageButton b2;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.event);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                StartEvent();
            }
        });


<<<<<<< HEAD
        b2 = (ImageButton) findViewById(R.id.surveyBut);
=======
        final ImageButton b2 = (ImageButton) findViewById(R.id.survey);
>>>>>>> 5ffeb5d708cc7924515d5192f8c5f8a127335896
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click+
                StartSurvey();
            }
        });
    }
    public void StartSurvey() {
<<<<<<< HEAD
        finish();
=======
>>>>>>> 5ffeb5d708cc7924515d5192f8c5f8a127335896
        Intent myEvent = new Intent(getApplicationContext(), SurveyActivity.class);
        startActivity(myEvent);
    }
    public void StartEvent() {
        finish();
        Intent myEvent = new Intent(getApplicationContext(), CategoryActivity.class);
        startActivity(myEvent);
    }
}
