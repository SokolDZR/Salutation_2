package com.example.ordi.salutation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button comeInB;
    ImageView ourVkImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        comeInB = (Button) findViewById(R.id.comeInB);
        comeInB.setOnClickListener(this);
        ourVkImg = (ImageView) findViewById(R.id.ourVkImg);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comeInB:
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
