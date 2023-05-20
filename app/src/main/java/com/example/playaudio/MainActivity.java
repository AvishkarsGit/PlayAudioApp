package com.example.playaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.*;
import android.net.*;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    Button pause,play,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pause = findViewById(R.id.btnPause);
        play = findViewById(R.id.btnPlay);
        stop =  findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String audioPath = "android.resource://"+getPackageName()+"/"+R.raw.jagdamb;

        Uri uri = Uri.parse(audioPath);

        try {
            mp.setDataSource(getApplicationContext(),uri);
            mp.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });
    }

}