package com.example.dwaygon.tap_blockv2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class game_loop extends AppCompatActivity implements View.OnClickListener {
    public int[] BUTTON_IDS = {
            R.id.touche0,
            R.id.touche1,
            R.id.touche2,
            R.id.touche3,
            R.id.touche4,
            R.id.touche5,
            R.id.touche6,
            R.id.touche7,
            R.id.touche8,
            R.id.touche9,
            R.id.touche10,
            R.id.touche11,
            R.id.touche12,
            R.id.touche13,
            R.id.touche14,
            R.id.touche15,
            R.id.touche16,
            R.id.touche17,
            R.id.touche18,
            R.id.touche19,
            R.id.touche20,
            R.id.touche21,
            R.id.touche22,
            R.id.touche23,
            R.id.touche24,
            R.id.touche25,
            R.id.touche26,
            R.id.touche27,
            R.id.touche28,
            R.id.touche29,
            R.id.touche30,
            R.id.touche31,
            R.id.touche32,
            R.id.touche33,
            R.id.touche34,
            R.id.touche35,
    };
    public Button buttons[] = new Button[BUTTON_IDS.length];
    Button touche36;
    Button touche37;
    Button touche38;
    Button touche39;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_loop);
        GridLayout grille = findViewById(R.id.grille);
        int i = 0;

        for (int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setOnClickListener(this); // maybe
            button.setBackgroundColor(Color.argb(0, 0, 0, 0));
            buttons[i] = button;
            i += 1;
        }
        touche36 = findViewById(R.id.touche36);
        touche36.setBackgroundColor(Color.argb(255, 255, 255, 255));
        touche36.setText("Score:");
        touche37 = findViewById(R.id.touche37);
        touche37.setBackgroundColor(Color.argb(255, 255, 255, 255));
        touche37.setText("0");
        touche38 = findViewById(R.id.touche38);
        touche38.setBackgroundColor(Color.argb(255, 255, 255, 255));
        touche38.setText("Vie");
        touche39 = findViewById(R.id.touche39);
        touche39.setBackgroundColor(Color.argb(255, 255, 255, 255));
        touche39.setText("3");
    }


    private int choose_color(){
        Random rnd=new Random();
        int aleacol = rnd.nextInt(3);
        switch (aleacol){
            case 0:
                return Color.argb(255,0,160,0);
            case 1:
                return Color.argb(255,0,0,160);
            case 2:
                return Color.argb(255,100,69,19);

        }
        return 0;
    }

    public void onStart() {
        super.onStart();
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long startTime = System.currentTimeMillis();
                long endtime = startTime;
                long delai = 2000;
                Random rnd=new Random();
                int aleabut;
                aleabut = rnd.nextInt(36);
                buttons[aleabut].setBackgroundColor(choose_color());
                try { Thread.sleep(delai); }
                catch (InterruptedException e) { return; }
                while(Integer.parseInt((touche39.getText()).toString()) > 0) {
                    ColorDrawable b_color = (ColorDrawable) buttons[aleabut].getBackground();
                    int a = b_color.getColor();
                    if (a !=Color.argb(0,0,0,0)) {
                        buttons[aleabut].setBackgroundColor(Color.argb(0, 0, 0, 0));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int convert = Integer.parseInt((touche39.getText()).toString());
                                convert -= 1;
                                touche39.setText(Integer.toString(convert));
                            }
                        });
                    }
                    aleabut = rnd.nextInt(36);
                    buttons[aleabut].setBackgroundColor(choose_color()); //bis
                    try { Thread.sleep(delai); }
                    catch (InterruptedException e) { return; }
                    endtime = System.currentTimeMillis();
                    if((endtime - startTime) > 5000){
                        delai = delai / 2;
                        startTime = endtime;
                    }
                }
                buttons[aleabut].setBackgroundColor(Color.argb(0,0,0,0));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(Button id : buttons ){
                            id.setEnabled(false);

                        }
                    }
                });

                //call score_activity;
                if (Integer.parseInt((touche37.getText()).toString())==0){
                    Intent gameActivity = new Intent(game_loop.this, score_activity.class);
                    gameActivity.putExtra("scorekey",-1);
                    startActivity(gameActivity);
                    finish();
                }
                else {
                    Intent gameActivity = new Intent(game_loop.this, score_activity.class);
                    gameActivity.putExtra("scorekey", Integer.parseInt((touche37.getText()).toString()));
                    startActivity(gameActivity);
                    finish();
                }
            }
        });
        background.start();
    }

    @Override
    public void onClick(View v) {
        Button B1 = v.findViewById(v.getId());
        ColorDrawable b_color = (ColorDrawable) B1.getBackground();
        int a = b_color.getColor();
        if(a != Color.argb(0,0,0,0)){
            B1.setBackgroundColor(Color.argb(0,0,0,0));
            int convert = Integer.parseInt((touche37.getText()).toString());
            convert += 1;
            touche37.setText(Integer.toString(convert));
        }else{
            int convert = Integer.parseInt((touche39.getText()).toString());
            convert -= 1;
            touche39.setText(Integer.toString(convert));
        }
    }




}
