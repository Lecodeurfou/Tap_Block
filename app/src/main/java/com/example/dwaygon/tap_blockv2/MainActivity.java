package com.example.dwaygon.tap_blockv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(btnPlay);
        btn2 = (Button) findViewById(R.id.btn2);




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(btnBoss);






    }

    private View.OnClickListener btnPlay = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent gameActivity = new Intent(MainActivity.this, game_loop.class);
            startActivity(gameActivity);
        }
    };



    private View.OnClickListener btnBoss = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent gameActivity = new Intent(MainActivity.this, game_loop_boss.class);
            startActivity(gameActivity);
        }
    };







}
