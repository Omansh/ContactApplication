package com.omansh.Dialer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<Contact> listOfContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

    }


    @Override
    protected void onResume() {
        super.onResume();

        MyDbHelper myDbHelper = new MyDbHelper(MainActivity.this);
        listOfContacts = myDbHelper.getContact();

        MyAdapter myAdapter = new MyAdapter(MainActivity.this , listOfContacts);
        listview.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_operation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_add) {
            Toast.makeText(MainActivity.this, "Add Contact", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, NewUser.class);
            startActivity(intent);
        }

        return true;
    }

}
