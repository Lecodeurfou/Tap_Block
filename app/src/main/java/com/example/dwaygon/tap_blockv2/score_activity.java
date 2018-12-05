package com.example.dwaygon.tap_blockv2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.dwaygon.tap_blockv2.R.id.image_view_victory;

public class score_activity extends AppCompatActivity {

    private ImageButton btn_backmenu;
    private ImageButton btn_replay;
    private ImageView victoryScreen;
    private ImageView defeatScreen;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_activity);
        victoryScreen = findViewById(R.id.image_view_victory);
        defeatScreen=findViewById(R.id.image_view_defeat);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int score = extras.getInt("scorekey");
            long score_boss=extras.getLong("timekey");
            //The key argument here must match that used in the other activity

            TextView view = findViewById(R.id.score_text);


            btn_replay =(ImageButton) findViewById(R.id.imageButton_replay);



            if (score == 0) { //Boss

                if(score_boss>=20000){
                    //  view.setText("Vous avez été défait par votre enemi ...");
                    //add image ajout du tps restant

                    defeatScreen.setBackgroundResource(R.drawable.scoretab2);

                }
                else{

                    //  view.setText("Vous avez défait votre enemi, félicitation !");
                    //add image etc ...

                    victoryScreen.setBackgroundResource(R.drawable.scoretab);


                }

                btn_replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gameActivity = new Intent(score_activity.this, game_loop_boss.class);
                        startActivity(gameActivity);
                        finish();
                    }
                });



            }
            if (score != 0) { //Arcade
                view.setText("Score : " + Integer.toString(score));

                victoryScreen.setBackgroundResource(R.drawable.scoretab);



                btn_replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gameActivity = new Intent(score_activity.this, game_loop.class);
                        startActivity(gameActivity);
                        finish();
                    }
                });





            }

        }





        btn_backmenu =(ImageButton) findViewById(R.id.imageButton_backmenu);

        btn_backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // finishActivity(0);
                Intent gameActivity = new Intent(score_activity.this, MainActivity.class);
                startActivity(gameActivity);
                finish();
            }
        });




    }
}
