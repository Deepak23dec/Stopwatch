package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int second=0;
Toolbar toolbar;
boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Digital Stopwatch");
        setSupportActionBar(toolbar);
  starttimmer();
}
    public void onClickstart(View view) {
      isRunning=true;
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();

    }
    public void onClickpause(View view) {
        isRunning=false;
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();}
    public void onClickreset(View view) {
        isRunning=false;
    second=0;
        Toast.makeText(this, "Reset stopwatch", Toast.LENGTH_SHORT).show();}
    //************************************************************************
    public void starttimmer()
    {TextView tv=findViewById(R.id.tv);

        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int s=second%60;
                int m=second/60;
                int h=m/60;
             if(isRunning){
                 second++;}

                String settv=String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
               tv.setText(settv);
               handler.postDelayed(this,1000);
            }
        };handler.post(runnable);

    }
}