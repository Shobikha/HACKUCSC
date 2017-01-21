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
//        int numOfItems = 4;
//        CheckBox[] chkItem = new CheckBox[numOfItems];
//        String[] itemList = {"program", "music", "list"};
//
//        for(int i = 0; i < chkItem.length; i++) {
//            chkItem[i] = (CheckBox) getResources().getIntArray(R.array. );
//        }

        Intent myEvent = new Intent(getApplicationContext(), EventActivity.class);
        if(checkProgram.isChecked()) {
            myEvent.putExtra("program", true);
        }
        else {
            myEvent.putExtra("program", false);
        }

        myEvent.putExtra("music", true);
        myEvent.putExtra("game", true);

        startActivity(myEvent);


    }

}
