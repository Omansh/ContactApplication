package com.omansh.Dialer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Omansh on 9/7/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper {

    Context mContext;
    public MyDbHelper(Context context){
        super(context,"Contact_db",null,1);
        this.mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Contact(name varchar(50),phonenumber varchar(50),emailid varchar(50),address varchar(250));");
    }

    public void insertStudent(Contact contact){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",contact.getName());
        contentValues.put("phonenumber",contact.getPhoneNumber());
        contentValues.put("emailid",contact.getEmailId());
        contentValues.put("address",contact.getAddress());

        long id=sqLiteDatabase.insert("Contact",null,contentValues);
        Toast.makeText(mContext,""+id,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Contact> getContact(){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from Contact",null);

        ArrayList<Contact> arraylist=new ArrayList<>();
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                String name=cursor.getString(0);
                String phonenumber=cursor.getString(1);
                String emailid=cursor.getString(2);
                String address=cursor.getString(3);

                Contact contact=new Contact();
                contact.setName(name);
                contact.setPhoneNumber(phonenumber);
                contact.setEmailId(emailid);
                contact.setAddress(address);

                arraylist.add(contact);

                cursor.moveToNext();

            }
        }
        return arraylist;

    }
}
