package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    public MyDataBaseHelper(Context context) {
        super(context, "myRegistratio", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //using to create simple data table
        /*    ______________________________
         *    |==#PK========Str======Str=====|
         *    | phoneNum | email | password  |
         *    ------------------------------
         */
        db.execSQL("Create table users (email text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    //registration method
    public boolean inseartData(String mail, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("email",mail);
        values.put("password",password);
        long ins= db.insert("users",null,values);
        if (ins==-1)
            return false;
        else
            return true;
    }

    //checking email if exist
    public boolean emailChecker(String email){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from users where email=?",new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else return true;
    }

    //login by email
    public boolean logingOperation(String iEmail,String iPassword){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email =? and password=?", new String[]{iEmail,iPassword});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
