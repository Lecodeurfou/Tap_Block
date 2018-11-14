package com.example.dwaygon.tap_blockv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class score_activity extends AppCompatActivity {

    private ImageButton btn_backmenu;
    private ImageButton btn_replay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_activity);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int score = extras.getInt("scorekey");
            long score_boss=extras.getLong("timekey");
            //The key argument here must match that used in the other activity

            TextView view = findViewById(R.id.score_text);
            TextView view_score= findViewById(R.id.score_text_number);


            btn_replay =(ImageButton) findViewById(R.id.imageButton_replay);




            if (score == 0) { //Boss

                if(score_boss>=5000){
                    view.setText("Vous avez été défait par votre enemi ...");
                    //add image etc ...
                    
                }
                else{
                    view.setText("Vous avez défait votre enemi, félicitation !");
                    //add image ajout du tps restant

                }

                btn_replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gameActivity = new Intent(score_activity.this, game_loop_boss.class);
                        startActivity(gameActivity);
                    }
                });



            }
            if (score != 0) { //Arcade
                view.setText("Score : ");
                view_score.setText(Integer.toString(score));



                btn_replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gameActivity = new Intent(score_activity.this, game_loop.class);
                        startActivity(gameActivity);
                    }
                });





            }

        }





        btn_backmenu =(ImageButton) findViewById(R.id.imageButton_backmenu);

        btn_backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  finish();
                Intent gameActivity = new Intent(score_activity.this, MainActivity.class);
                startActivity(gameActivity);
            }
        });




    }
}
