package com.example.regson.netwalkgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Displays the mainmenu.
 * Created by Regson on 18/02/2017.
 */

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
        onButtonClick();

    }

    /**
     *Method to decide what to do for each button click
     */
    private void onButtonClick() {
        Button srtNGame = (Button) findViewById(R.id.btnNewGame);
        Button opnHelp = (Button) findViewById(R.id.btnHelp);
        Button opnScores = (Button) findViewById(R.id.btnHScores);
        ImageButton opnSet = (ImageButton) findViewById(R.id.btnSettings);

        opnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(MainMenuActivity.this, SettingsActivity.class);
                startActivity(inte);
            }
        });

        srtNGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inte = new Intent(MainMenuActivity.this, ChooseLevelActivity.class);
                    startActivity(inte);
                }
            });


            opnScores.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inte = new Intent(MainMenuActivity.this, HighscoreActivity.class);
                    startActivity(inte);
                }
            });


            opnHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inte = new Intent(MainMenuActivity.this, HowToPlayActivity.class);
                    startActivity(inte);
                }
            });

    }
}
