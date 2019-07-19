package com.example.regson.netwalkgame;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * This class is the activity which has the grid and the counter/timer.
 * Created by Regson on 1/02/2017.
 */

public class GameActivity extends AppCompatActivity {
    public static int DEFAULT_COLUMNS;
    public static int DEFAULT_ROWS;
    private DatabaseHandler db;

    /**
     *      Main Activity which will create the grid. The gameview is added onto the layout xml file.
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRowCol();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        db = new DatabaseHandler(this);
        GameView mView = new GameView(this, null);
        relativeLayout.addView(mView);
        onButtonClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    /**
     * Retrieve level information from the seekbar.
     */
    private void setRowCol() {
        Intent intent = getIntent();
        int numberData = intent.getIntExtra("chosenlvl",3);
        if (numberData==0){
            numberData=numberData+3;
        }
        DEFAULT_ROWS = numberData;
        DEFAULT_COLUMNS = numberData;
    }

    /**
     * New game button
     */
    private void onButtonClick() {
        Button srtNGame = (Button) findViewById(R.id.buttonNewGame);
        srtNGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = GameActivity.this;
                activity.finish();
            }
        });
    }

}

