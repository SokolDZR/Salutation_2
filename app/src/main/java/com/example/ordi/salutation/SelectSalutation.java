package com.example.ordi.salutation;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

public class SelectSalutation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_salutation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton selectSalFab = (FloatingActionButton) findViewById(R.id.selectSalFab);
        selectSalFab.setBackgroundTintList(ColorStateList.valueOf(Color
                .parseColor("#13c97a")));
        selectSalFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), DataInputActivity.class));
            }
        });
        // стрелка "назад"
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
