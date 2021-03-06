package com.example.lab714_pc.drug;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;



import static android.content.Context.NOTIFICATION_SERVICE;
import static android.media.AudioAttributes.USAGE_NOTIFICATION;
import static com.example.lab714_pc.drug.Base.notification;

/**
 * Created by idmakers on 2017/10/26.
 */


public class PlayReceiver extends BroadcastReceiver {

    private SoundPool sp;
    private boolean spLoader = false;
    MediaPlayer mPlayer = new MediaPlayer();


    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bData = intent.getExtras();
        Log.w("time", "onReceive: " + bData.get("time") );



        if (bData.get("msg").equals("play_voice"+1+1)) {



//            SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//
//            /** soundId for Later handling of sound pool **/
//            int soundId = sp.load(context, R.raw.test, 1); // in 2nd param u have to pass your desire ringtone
//
//            sp.play(soundId, 1, 1, 0, 0, 1);

            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog1");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            Log.w("MSG", "onReceive: +1" );
            context.startActivity(intentDialog);



            //mPlayer.prepare();




        }
        else if (bData.get("msg").equals("play_voice"+2+1)){
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;

            Log.w("MSG", "onReceive: +2" );
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog2");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);

        }
        else if (bData.get("msg").equals("play_voice"+3+1)){
            Log.w("MSG", "onReceive: +3" );
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog3");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);


        }
        else if (bData.get("msg").equals("play_voice"+4+1)){
            Log.w("MSG", "onReceive: +4" );
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog4");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);

        }
        else if (bData.get("msg").equals("play_voice"+1+2)){
            Log.w("MSG", "onReceive: +4" );
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog5");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);

        }
        else if (bData.get("msg").equals("play_voice"+2+2)){
            Log.w("MSG", "onReceive: +4" );
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog6");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);

        }
        else if (bData.get("msg").equals("play_voice"+3+2)){
            Log.w("MSG", "onReceive: +4" );
            long tstart = System.currentTimeMillis();
            long time  = tstart;
            long timepass = 0;
            Intent intentDialog = new Intent();
            intentDialog.setClass(context,DIalog.class);
            intentDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentDialog.putExtra("message","Dialog7");
//            while (time < tstart+10000){
//                time = System.currentTimeMillis();
//                //timepass = time-tstart;
//                //Log.d("time","value "+timepass);
//            }
            context.startActivity(intentDialog);

        }
    }
}


/*
    public void playSounds(int repeatTime, Context context) {
        AudioManager am = (AudioManager) context.getApplicationContext()
                .getSystemService(Context.AUDIO_SERVICE);
        // 獲取最大音量
        float audMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 獲取目前音量
        float audCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        // 左右聲道值範圍為 0.0 - 1.0
        float volRatio = audCurrentVolumn / audMaxVolumn;
        // 下面參數分別為播放音頻，左聲道,右聲道，設置優先級，重撥次數，速率(速率最低0.5，最高為2，1代表正常速度)
        sp.play(R.raw.test, volRatio, volRatio, 1, repeatTime, 1);
    }*/
