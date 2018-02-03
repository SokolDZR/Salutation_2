package com.example.ordi.salutation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity{

    protected Switch switchNot, switchSound, switchVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);

        switchNot = (Switch) findViewById(R.id.switchNot);
        switchNot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String notification = "";
                if (isChecked) {
                    notification = "On";
                    switchSound.setChecked(true);
                    switchSound.setEnabled(true);
                    switchVibration.setChecked(true);
                    switchVibration.setEnabled(true);
                } else {
                    notification = "Off";
                    switchSound.setChecked(false);
                    switchSound.setEnabled(false);
                    switchVibration.setChecked(false);
                    switchVibration.setEnabled(false);

                }
                SharedPreferences notificationPref = getSharedPreferences("notification", MODE_PRIVATE);
                SharedPreferences.Editor editor = notificationPref.edit();
                editor.putString("NotificationSet", notification);
                editor.apply();
            }
        });

        switchSound = (Switch) findViewById(R.id.switchSound);
        switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String sound = "";
                if (isChecked) {
                    sound = "On";
                } else {
                    sound = "Off";
                }
                SharedPreferences notificationPref = getSharedPreferences("notification", MODE_PRIVATE);
                SharedPreferences.Editor editor = notificationPref.edit();
                editor.putString("SoundSet", sound);
                editor.apply();
            }
        });

        switchVibration = (Switch) findViewById(R.id.switchVibration);
        switchVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String vibration = "";
                if (isChecked) {
                    vibration = "On";
                } else {
                    vibration = "Off";
                }
                SharedPreferences settings = getSharedPreferences("notification", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("VibrationSet", vibration);
                editor.apply();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings = getSharedPreferences("notification", MODE_PRIVATE);
        String notification = settings.getString("NotificationSet"," ");
        switch (notification){
            case("On"): switchNot.setChecked(true); break;
            case("Off"): switchNot.setChecked(false);
                break;
        }

        String sound = settings.getString("SoundSet"," ");
        switch (sound){
            case("On"): switchSound.setChecked(true); break;
            case("Off"): switchSound.setChecked(false);
                break;
        }
        String vibration = settings.getString("VibrationSet"," ");
        switch (vibration){
            case("On"): switchVibration.setChecked(true); break;
            case("Off"): switchVibration.setChecked(false);
                break;
        }
    }



}