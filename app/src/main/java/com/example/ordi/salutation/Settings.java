package com.example.ordi.salutation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity{

    private Switch switchNot;
    private Switch switchSound;
    private Switch switchVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(getString(R.string.ActoinBarColor))));
        switchNot = (Switch) findViewById(R.id.switchNot);
        switchNot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String notification = "";
                // в зависимости от значения isChecked выводим нужное сообщение
                if (isChecked) {
                    notification = "On";
                } else {
                    notification = "Off";
                }
                SharedPreferences preferences = getSharedPreferences("button", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("NotificationSet", notification);
                editor.apply();
            }
        });
        switchSound = (Switch) findViewById(R.id.switchSound);
        switchVibration = (Switch) findViewById(R.id.switchVibration);
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("button", MODE_PRIVATE);
        String notification = preferences.getString("NotificationSet"," ");
        switch (notification){
            case("On"): switchNot.setChecked(true); break;
            case("Off"): switchNot.setChecked(false);
                break;
        }
    }


}