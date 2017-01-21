package com.example.alex.leggo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    int currItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

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

        currItem = getIntent().getExtras().getInt("currItem");

        setImg();
        setTitle();
        setDistance();
        setDescription();
        Button b = (Button) findViewById(R.id.yes);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor join = getSharedPreferences("save", MODE_PRIVATE).edit();
                join.putInt("event", 1);
            }
        });
    }

    public void setTitle() {

        TextView t=(TextView)findViewById(R.id.eventList);

    }

    private String[] eventsID = {
            "Programming",
    };
    private Integer[] Imgid = {

            R.drawable.python_640x400, R.drawable.web_design_schools, R.drawable.network_security

    };


    public void setImg() {
        ImageView img = (ImageView) findViewById(R.id.eventImg);
        img.setImageResource(Imgid[0]);
    }

    public void setDistance() {
        TextView t = (TextView) findViewById(R.id.description);

    }

    public void setDescription() {
        TextView t = (TextView) findViewById(R.id.description);
    }
    public void mainActivity() {
        Intent nextTime = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextTime);
    }
    public void nextItem() {

        Intent nextTime = new Intent(getBaseContext(), EventActivity.class);
//
//        for(int i = 0; i < chkItem.length; i++) {
//            if(chkItem[i].isChecked()){
//
//                myEvent.putExtra(items.getItem(i), true);
//            } else {
//                myEvent.putExtra(items.getItem(i), false);
//
//            }
//        }
//        myEvent.putExtra("currItem", currItem + 1);

    }

}
