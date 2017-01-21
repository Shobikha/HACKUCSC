package com.example.alex.leggo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by alex on 1/21/17.
 */

public class CategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        final Activity activity = this;
        activity.setTitle("Areas of Interest");
    }

}
