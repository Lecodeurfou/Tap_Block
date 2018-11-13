package com.example.dwaygon.tap_blockv2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score_activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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

            if (score == 0) { //Boss

                if(score_boss>=5000){
                    view.setText("Vous avez été défait par votre enemi ...");
                    //add image etc ...
                }
                else{
                    view.setText("Vous avez défait votre enemi, félicitation !");
                    //add image ajout du tps restant

                }


            }
            if (score != 0) { //Arcade
                view.setText("Score : ");
                view_score.setText(Integer.toString(score));

            }

        }





    }
}
