package com.example.alex.leggo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by alex on 1/21/17.
 */

public class CategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final Button complete = (Button) findViewById(R.id.complete);
        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startEvent();
            }
        });
    }

    public void startEvent() {

        final CheckBox checkProgram = (CheckBox) findViewById(R.id.program);
        list items = new list();
        int numOfItems = items.length();
        CheckBox[] chkItem = new CheckBox[numOfItems];

        chkItem[0] = (CheckBox) findViewById(R.id.program);
        chkItem[1] = (CheckBox) findViewById(R.id.music);
        chkItem[2] = (CheckBox) findViewById(R.id.game);
        chkItem[3] = (CheckBox) findViewById(R.id.all);
        chkItem[4] = (CheckBox) findViewById(R.id.sports);
        chkItem[5] = (CheckBox) findViewById(R.id.fieldTrips);
        chkItem[6] = (CheckBox) findViewById(R.id.networking);
        chkItem[7] = (CheckBox) findViewById(R.id.photography);


        Intent myEvent = new Intent(getApplicationContext(), EventActivity.class);

        for(int i = 0; i < chkItem.length; i++) {
            if(chkItem[i].isChecked()){

            myEvent.putExtra(items.getItem(i), true);
            } else {
                myEvent.putExtra(items.getItem(i), false);

            }
        }
        myEvent.putExtra("currItem", 1);

        startActivity(myEvent);


    }

}
