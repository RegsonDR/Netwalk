package com.example.regson.netwalkgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Displays the settings
 * Created by Regson on 18/02/2017.
 */

public class SettingsActivity extends AppCompatActivity {
    private EditText playerName;
    private int selectedTheme;
    private final String[]theme={"Dark","Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        playerName = (EditText) findViewById(R.id.editTextName);
        Spinner dropSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SettingsActivity.this,
                android.R.layout.simple_spinner_item, theme);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropSpinner.setAdapter(adapter);
        dropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTheme=position;
                Toast.makeText(SettingsActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        onButtonClick();
    }

    private void onButtonClick() {
        Button opnHelp = (Button) findViewById(R.id.btnSave);

        opnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(SettingsActivity.this, MainMenuActivity.class);
                GameView.pName=playerName.getText().toString();
                GameView.themeBlue = selectedTheme == 1;
                startActivity(inte);
            }
        });
    }
}
