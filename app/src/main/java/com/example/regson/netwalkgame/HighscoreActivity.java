package com.example.regson.netwalkgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SeekBar;
import android.widget.TextView;
/**
 *  This class displays the seekbar and the recycler view onto the screen
 * Created by Regson on 08/02/2017
 */
public class HighscoreActivity extends AppCompatActivity {
    private TextView txtGameMode;
    private RecyclerView recList;
    private int rowColAmount;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        seekbarSet();
        recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        lookDB();
    }
    private void seekbarSet(){
        SeekBar skBar = (SeekBar) findViewById(R.id.seekBarHS);
        skBar.setMax(7);
        int progress = skBar.getProgress() + 3;

        txtGameMode = (TextView) findViewById(R.id.txtViewGridSizehs);
        txtGameMode.setText("Highscore: "+ progress +"x"+ progress);
        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rowColAmount=progress+3;
                txtGameMode.setText("Highscore: "+ rowColAmount+"x"+rowColAmount);
                lookDB();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (rowColAmount==0){
                    rowColAmount=rowColAmount+3;
                }
                txtGameMode.setText("Highscore: "+ rowColAmount+"x"+rowColAmount);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtGameMode.setText("Highscore: "+ rowColAmount+"x"+rowColAmount);
            }
        });
    }

    /**
     *gets the information from the database to populate the recycle view
     */
    private void lookDB() {
        db = new DatabaseHandler(this);
        if (rowColAmount==0){
            rowColAmount=rowColAmount+3;
        }
        HighscoreAdapter ca = new HighscoreAdapter(db.getPlayers(rowColAmount));
        recList.setAdapter(ca);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
