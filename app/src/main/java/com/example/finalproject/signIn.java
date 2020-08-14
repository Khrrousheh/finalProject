package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIn extends AppCompatActivity {
    MyDataBaseHelper db;
    EditText mail,pass;
    Button login,singnnUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        db= new MyDataBaseHelper(this);
        mail = (EditText) findViewById(R.id.Mail_textF);
        pass= (EditText) findViewById(R.id.pass_textF);

        login= (Button) findViewById(R.id.Login_button);
        singnnUp = (Button) findViewById(R.id.signup_button);
        singnnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inty= new Intent(signIn.this,signup.class);
                startActivity(inty);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String myMail = mail.getText().toString(), pasword= pass.getText().toString();
                Boolean checking = db.logingOperation(myMail,pasword);
                if(checking== true){
                    Toast.makeText(getApplicationContext(),"Successful Loging",Toast.LENGTH_SHORT).show();
                    //put the intent
                    Intent inss= new Intent(signIn.this,MapsActivity.class);
                    startActivity(inss);

                }else{
                    Toast.makeText(getApplicationContext(),"wrong email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
}
}
