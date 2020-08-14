package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    MyDataBaseHelper db;
    EditText e1,e2,e3;
    Button eesaignUp,signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db= new MyDataBaseHelper(this);
        e1= (EditText) findViewById(R.id.reMail_textF);//mail
        e2=(EditText) findViewById(R.id.repass_textF);//password
        e3= (EditText) findViewById(R.id.reconfigass_textF);//password configuration

        eesaignUp= (Button) findViewById(R.id.reLogin_button);
        signIn= (Button) findViewById(R.id.signin_button);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1= new Intent(signup.this,signIn.class);
                startActivity(in1);
            }
        });


        eesaignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail= e1.getText().toString(),
                        password=e2.getText().toString(),
                        confiPassword=e3.getText().toString();

                if(mail.equals("")||password.equals("")||confiPassword.equals(""))
                    Toast.makeText(getApplicationContext(),"please fill all fields",Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confiPassword)){
                        Boolean check= db.emailChecker(mail);
                        if (check == true){
                            Boolean insertion= db.inseartData(mail,password);
                            if(insertion == true){
                                Toast.makeText(getApplicationContext(),"Registration Complete",Toast.LENGTH_SHORT);
                                //intent for the guide
                                Intent intss= new Intent(signup.this,MapsActivity.class);
                                startActivity(intss);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"you mail is already registered",Toast.LENGTH_SHORT);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"you mail is already registered",Toast.LENGTH_SHORT);
                    }
                }

            }
        });


    }
}
