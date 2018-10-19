package com.listview.prog6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  ImageView img;
Button bt1, bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1  =(Button)findViewById(R.id.button);
        bt2=(Button) findViewById(R.id.button2);
        img=(ImageView)findViewById(R.id.image);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        img.post(new Runnable() {
                            @Override
                            public void run() {
                                img.setImageResource(R.drawable.cartoon);
                            }
                        });
                    }
                }).start();
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                img.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        img.setImageResource(R.drawable.cartoon2);
                                    }
                                });
                            }
                        }).start();
                    }
                });
            }
        });
    }
}
