package com.add.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button play, pause, stop;
MediaPlayer mediaPlayer;
int pausecurrentposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button)findViewById(R.id.button1);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button1:
                if(mediaPlayer==null){
                mediaPlayer=mediaPlayer.create(getApplicationContext(), R.raw.abcd);

                mediaPlayer.start();}
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausecurrentposition);
                    mediaPlayer.start();
                }
            break;

            case R.id.button2:
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                pausecurrentposition=mediaPlayer.getCurrentPosition();

                }
                break;

            case R.id.button3:
                if (mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null; }
                break;
        }

    }
}
