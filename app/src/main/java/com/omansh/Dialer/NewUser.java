package com.omansh.Dialer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Omansh on 9/5/2017.
 */

public class NewUser extends AppCompatActivity {

    EditText edtName,edtPhoneNo,edtEmail,edtAddress;
    Button btnAddContact;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_user);

        edtName= (EditText) findViewById(R.id.edtName);
        edtPhoneNo= (EditText) findViewById(R.id.edtPhoneNo);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtAddress= (EditText) findViewById(R.id.edtAddress);

        btnAddContact= (Button) findViewById(R.id.btnAddContact);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHelper myDbHelper=new MyDbHelper(NewUser.this);
                Contact contact=new Contact();
                contact.setName(edtName.getText().toString());
                contact.setPhoneNumber(edtPhoneNo.getText().toString());
                contact.setEmailId(edtEmail.getText().toString());
                contact.setAddress(edtAddress.getText().toString());

                myDbHelper.insertStudent(contact);


            }
        });



    }
}
