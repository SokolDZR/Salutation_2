package com.example.ordi.salutation;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DataInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton dataInputFab = (FloatingActionButton) findViewById(R.id.dataInputFab);
        dataInputFab.setBackgroundTintList(ColorStateList.valueOf(Color
                .parseColor("#13c97a")));
        dataInputFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Параметры введены", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // стрелка "назад"
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
