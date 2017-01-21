package com.example.alex.leggo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    Bundle currItem(){

    }


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

        setImg();
        setTitle();
        setDistance();
        setDescription();


    }
    public void setTitle() {

        TextView t=(TextView)findViewById(R.id.eventList);

        boolean isProgramChecked = getIntent().getExtras().getBoolean("program");
        list itemList = new list();
        for (int i = 0; i < itemList.length; i++) {

            if(getIntent().getExtras().getBoolean(itemList.getItem(i))) {
                t.setText("Web Design for Beginners, \n" +
                        "coding a website from scratch \n" +
                        "intro to programming: writing Python");
            } else {
                t.setText("");
            }
        }
        final int one = 1;
        final int two = 2;
        final int three= 3;
        final int four = 4;

        int currItem = getIntent().getExtras().getInt("currItem");
        switch (currItem) {
            case one:
                t.setText("Web Design for Beginners");
                break;
            case two:
                t.setText("Coding a website from Scratch!!");
                break;
            case three:
                t.setText("Python bitches!! ");
                break;
            default:
                break;
        }
    }

    private String[] eventsID = {
            "Programming",
    }
    private Integer[] Imgid = {

            R.drawable., R.drawable.a_2, R.drawable.a_3, R.drawable.a_4, R.drawable.a_5, R.drawable.a_6, R.drawable.a_7

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
//        myEvent.putExtra("currItem", 1);

    }

}
