package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile_info extends AppCompatActivity {
    private Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__info);

        b1= (Button) findViewById(R.id.mmmap);
        b2= (Button) findViewById(R.id.health);
        b3= (Button) findViewById(R.id.info);
        b4= (Button) findViewById(R.id.safe);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(profile_info.this, MapsActivity.class);
                startActivity(goMap);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(profile_info.this, health.class);
                startActivity(goMap);
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(profile_info.this, appInfo.class);
                startActivity(goMap);
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(profile_info.this, safe.class);
                startActivity(goMap);
            }
        });

    }
}
