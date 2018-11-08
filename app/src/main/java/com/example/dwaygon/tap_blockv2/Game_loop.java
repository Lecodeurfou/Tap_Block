package com.example.dwaygon.tap_blockv2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.lang.reflect.Array;
import java.util.Random;

public class Game_Loop  extends AppCompatActivity implements View.OnClickListener {
    Button buttons[] = new Button[BUTTON_IDS.length];
    private static final int[] BUTTON_IDS = {
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
            R.id.touche28,
            R.id.touche29,
            R.id.touche30,
            R.id.touche31,
            R.id.touche32,
            R.id.touche33,
            R.id.touche34,
            R.id.touche35,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__loop);
        GridLayout grille = findViewById(R.id.grille);
        int i = 0;
        for(int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setOnClickListener(this); // maybe
            buttons[i] = button;
            i+=1;
        }




    }
    public void onStart() {
        super.onStart();
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rnd=new Random();
                while(true) {
                    try { Thread.sleep(2000); }
                    catch (InterruptedException e) { return; }
                    buttons[rnd.nextInt(36)].setBackgroundColor(Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256))); //bis


                }
            }
        });
        background.start();
    }

    @Override
    public void onClick(View v) {
        Button B1 = v.findViewById(v.getId());
        Random rnd=new Random();  // a ajouter lors de l'event de pop de la touche
        B1.setBackgroundColor(Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256))); //bis

    }




}
