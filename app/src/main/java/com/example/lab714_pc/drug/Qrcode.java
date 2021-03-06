package com.example.lab714_pc.drug;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Qrcode extends AddByHand{
    private static final String TAG = Qrcode.class.getName();
    private Button btn_scan;
    private TextView txt_url;
    private TextView name , time ,amount ,before;
    private MyDBHelper helper;

//如QR SCAN 未掃瞄到結果跳出頁面 會強制中止程式
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        helper = new MyDBHelper(this,"expense.db",null,1);
        this.btn_scan = (Button)findViewById(R.id.scan);
        this.txt_url = (TextView) findViewById(R.id.txt_url);
        this.name = (TextView) findViewById(R.id.name);
        this.time = (TextView) findViewById(R.id.time);
        this.before = (TextView)findViewById(R.id.before);
        this.amount = (TextView) findViewById(R.id.amount);
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


        //點擊Button用IntentIntegration的initiateScan方法開始掃描
        this.btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(Qrcode.this).initiateScan();
            }
        });
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


    //掃描完的結果回傳到Activity，要用onActivityResult這個方法
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(result!=null){
            String scanContent = result.getContents();
            String scanFormat = result.getFormatName();
            txt_url.setText(scanContent); //將資料顯示到textView
            if(scanContent !=null){
                covert(scanContent);
            }
            else{
                Toast.makeText(getApplicationContext(), "nothing", Toast.LENGTH_LONG).show();
            }

        }


    }
    void covert(String string){
        String txt = string;
        if(txt.substring(0,2).equals("藥品")){
           Log.w("msg",txt.substring(0,2));
            for(int first=2 ; first< txt.length(); first++){
                int second = first+1;
               Log.w("msg",txt.substring(first,second));
                if(txt.substring(first ,second).equals("用")){
                    name.setText(txt.substring(3,first));
                    break;
                }
            }
        }

        for(int first=0 ; first< txt.length(); first++){
            int second =  first +1;
            if(txt.substring(first ,second).equals("早")){
                time.setText(txt.substring(first,second));
                break;
            }
            else  if(txt.substring(first ,second).equals("中")){
                time.setText(txt.substring(first,second));
                break;
            }
            else  if(txt.substring(first ,second).equals("晚")){
                time.setText(txt.substring(first,second));
                break;
            }

        }
        for(int first=0 ; first< txt.length(); first++){
            int second =  first +1;
            if(txt.substring(first ,second).equals("前")){
                before.setText(txt.substring(first,second));
                break;
            }
            else  if(txt.substring(first ,second).equals("後")) {
                before.setText(txt.substring(first, second));
                break;
            }

        }
        for(int first=0 ; first< txt.length(); first++){
            int second =  first +1;
            Log.w("day","day" +txt.substring(first,second) + first + second );
            if(txt.substring(first ,second).equals("份")){
                amount.setText(txt.substring(first-3,second-2));
                break;
            }


        }
        SimpleDateFormat date = new SimpleDateFormat("yyyy MM dd");
        Date today  = new Date();
        String date_string= date.format(today);
        ContentValues values = new ContentValues();
        helper.getWritableDatabase();
       
        if(helper.isEmpty()){
            Cursor morn = helper.filList(1);
            Cursor noo = helper.filList(2);
            Cursor ni = helper.filList(3);
            Cursor mid = helper.filList(4);
//            if(time.getText().toString().equals("早")){
//                _id = (int)System.currentTimeMillis();
//                alarm(morn.getString(1),_id);
//                values.put("morning",_id);
//               // values.put("morning",0);
//                values.put("noon",0);
//                //values.put("night",0);
//                values.put("midnight",0);
//
//            }
//            else if(time.getText().toString().equals("中")){
//                _id = (int)System.currentTimeMillis();
//                alarm(noo.getString(1),_id);
//                values.put("noon",_id);
//                values.put("morning",0);
//                values.put("noon",0);
//                values.put("night",0);
//                values.put("midnight",0);
//
//            }
//            else if(time.getText().toString().equals("晚")){
//                _id = (int)System.currentTimeMillis();
//                alarm(ni.getString(1),_id);
//                values.put("night",_id);
//                values.put("morning",0);
//                values.put("noon",0);
//                //values.put("night",0);
//                values.put("midnight",0);
//
//            }

//            else if(time.getText().toString().equals("睡前")){
//                _id = (int)System.currentTimeMillis();
//                alarm(mid.getString(1),_id);
//                values.put("midnight",_id);
//            }

//            else if(time.getText().toString().equals("早上/晚上")){
//                _id = (int)System.currentTimeMillis();
//                alarm(morn.getString(1),_id);
//                values.put("morning",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(ni.getString(1),_id);
//                values.put("night",_id);
//
//            }
//
//            else if(time.getText().toString().equals("早上/中午/晚上")){
//                _id = (int)System.currentTimeMillis();
//                alarm(morn.getString(1),_id);
//                values.put("morning",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(noo.getString(1),_id);
//                values.put("noon",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(ni.getString(1),_id);
//                values.put("night",_id);
//
//            }
//
//            else if(time.getText().toString().equals("早上/中午/晚上/睡前")){
//                _id = (int)System.currentTimeMillis();
//                alarm(morn.getString(1),_id);
//                values.put("morning",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(noo.getString(1),_id);
//                values.put("noon",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(ni.getString(1),_id);
//                values.put("night",_id);
//                _id = (int)System.currentTimeMillis();
//                alarm(mid.getString(1),_id);
//                values.put("midnight",_id);
//            }
        }

        values.put("name",name.getText().toString());
        values.put("method", 0);
        values.put("amount",28);
        values.put("bf",before.getText().toString());
        values.put("day", amount.getText().toString());
        values.put("tvTime", time.getText().toString());
        values.put("date",date_string);
        values.put("stop",1);
       Log.w("msg" , "test  " + values);
        long medinfo = helper.getWritableDatabase().insert("MEDINFO", null, values);
//        intent.setClass(Qrcode.this, Base.class);
//        startActivity(intent);




    }
}