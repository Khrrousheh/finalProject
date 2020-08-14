package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    Button getStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStart=(Button) findViewById(R.id.getStart) ;
        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String firstTimeInstall= preferences.getString("FirstTimeInstall","");

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inee= new Intent(welcome.this,signIn.class);
                startActivity(inee);
            }
        });

        if (firstTimeInstall.equals("YES")){
            Intent intent= new Intent(welcome.this,signIn.class);
            startActivity(intent);

        }else{
            SharedPreferences.Editor editor= preferences.edit();
            editor.putString("FirstTimeInstall","YES");
            editor.apply();
        }
    }
}
