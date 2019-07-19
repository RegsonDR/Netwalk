package com.example.regson.netwalkgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * This class is for the Level selector activity.
 * Created by Regson on 16/02/2017.
 */

public class ChooseLevelActivity extends AppCompatActivity {

    private TextView txtMode;
    private int rowColAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        seekbarSet();
        onButtonClick();
    }

    /**
     * this methods saves the input from the seek bar and will allow the GameActivity to retrieve the message.
     */
    private void onButtonClick() {
        Button btStartNewGame = (Button) findViewById(R.id.btnStartGame);
        btStartNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(ChooseLevelActivity.this, GameActivity.class);
                inte.putExtra("chosenlvl",getRowColAmount());
                startActivity(inte);
            }
        });
    }

    /**
     *
     * @return the amount of rows
     */
    private int getRowColAmount() {
        return rowColAmount;
    }

    /**
     * This method sets up the seek bar to link with the textview to show the mode properly.
     */
    private void seekbarSet(){
        SeekBar skBar = (SeekBar) findViewById(R.id.seekBarlvl);
        skBar.setMax(7);
        int progress = skBar.getProgress() + 3;

        txtMode = (TextView) findViewById(R.id.txtViewGridSize);
        txtMode.setText(progress +"x"+ progress);

        //Code which allows textview to update with the seek bar
        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            rowColAmount=progress+3;
                txtMode.setText(rowColAmount+"x"+rowColAmount);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (rowColAmount==0){
                    rowColAmount=rowColAmount+3;
                }
                txtMode.setText(rowColAmount+"x"+rowColAmount);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtMode.setText(rowColAmount+"x"+rowColAmount);
            }
        });
    }
}
