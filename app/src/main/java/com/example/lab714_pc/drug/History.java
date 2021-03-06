package com.example.lab714_pc.drug;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class History extends Base{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        btadd = (Button) findViewById(R.id.addh);
        btadd.setOnClickListener(onClickListener);
        btitem = (Button) findViewById(R.id.item);
        btitem.setOnClickListener(onClickListener);
        btalarm = (Button) findViewById(R.id.alarm);
        btalarm.setOnClickListener(onClickListener);
        btalarmL = (Button) findViewById(R.id.QRcode);
        btalarmL.setOnClickListener(onClickListener);
        btnotify = (Button) findViewById(R.id.Notification);
        btnotify.setOnClickListener(onClickListener);
        history = (Button) findViewById(R.id.history);
        history.setOnClickListener(onClickListener);
        ListView list = (ListView) findViewById(R.id.list);
        MyDBHelper helper = new MyDBHelper(this, "expense.db", null, 1);
        Cursor c = helper.getReadableDatabase().rawQuery("SELECT * FROM  MEDINFO WHERE amount < '' +0+ ''  ORDER BY name  " , null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.content_itemlistview,
                c,
                new String[] { "tvTime","day","name","amount","DATE"},
                new int[] { R.id.item_time, R.id.item_day, R.id.item_name,R.id.amount,R.id.item_date}, 0);
        //new String[] {"name", "amount"},
        //new int[] {android.R.id.text1, android.R.id.text2},0);

        list.setAdapter(adapter);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





    }
//1526663220000
}
