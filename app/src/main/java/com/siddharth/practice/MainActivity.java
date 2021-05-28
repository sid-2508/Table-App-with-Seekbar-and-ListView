package com.siddharth.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

public void playAudio(View view){

    int btnid = view.getId();

    String buttonID = view.getResources().getResourceEntryName(btnid);

    int resourceId = view.getResources().getIdentifier(buttonID , "raw" , "com.siddharth.practice");

    MediaPlayer mediaPlayer = MediaPlayer.create(this , resourceId);
    mediaPlayer.start();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}