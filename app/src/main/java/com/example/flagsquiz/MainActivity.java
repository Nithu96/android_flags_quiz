package com.example.flagsquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private boolean isTimerOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------Creating the Activity Pages------------------------------------------------
        Button FlagButton1= (Button)findViewById(R.id.FlagButton1);
        Button FlagButton2= (Button)findViewById(R.id.FlagButton2);
        Button FlagButton3= (Button)findViewById(R.id.FlagButton3);
        Button FlagButton4= (Button)findViewById(R.id.FlagButton4);
        final Switch timer=findViewById(R.id.switchTimer);
        timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isTimerOn =true;
                } else {
                    isTimerOn =false;
                }
            }
        });
        //---------Guess the country button page open -----------------
        FlagButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb1 = new Intent(MainActivity.this,GuessCountry.class);
                intentb1.putExtra("timer",isTimerOn);
                startActivity(intentb1);
            }
        });

        //---------Guess the hints button page open----------------------
        FlagButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb2 = new Intent(MainActivity.this,GuessHints.class);
                intentb2.putExtra("timer",isTimerOn);
                startActivity(intentb2);
            }
        });

        //---------Guess the flag button page open------------------------
        FlagButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb3 = new Intent(MainActivity.this,GuessTheFlag.class);
                intentb3.putExtra("timer",isTimerOn);
                startActivity(intentb3);
            }
        });

        //--------Advanced Level button page open------------------
        FlagButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb4 = new Intent(MainActivity.this,AdvancedLevel.class);
                intentb4.putExtra("timer",isTimerOn);
                startActivity(intentb4);
            }
        });



    }

    //------- option menu ----------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
