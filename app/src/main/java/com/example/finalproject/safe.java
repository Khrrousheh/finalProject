package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class safe extends AppCompatActivity {
    private Button b1,b2,b3,b4,call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);


        b1 = (Button) findViewById(R.id.mmmap);
        b2 = (Button) findViewById(R.id.health);
        b3 = (Button) findViewById(R.id.info);
        b4 = (Button) findViewById(R.id.safe);
        call = (Button) findViewById(R.id.aleartButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(safe.this, MapsActivity.class);
                startActivity(goMap);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(safe.this, health.class);
                startActivity(goMap);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(safe.this, appInfo.class);
                startActivity(goMap);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(safe.this, safe.class);
                startActivity(goMap);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAction = new Intent((Intent.ACTION_CALL));
                myAction.setData(Uri.parse("tel:911"));
                if (ActivityCompat.checkSelfPermission(safe.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(safe.this, "please grant the permission to call", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(myAction);
                }
            }
        });
    }
    private  void requestPermission(){

        ActivityCompat.requestPermissions(safe.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}