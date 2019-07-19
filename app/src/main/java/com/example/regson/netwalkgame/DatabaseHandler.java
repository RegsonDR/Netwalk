package com.example.regson.netwalkgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles all the database actions.
 * Created by Regson on 16/02/2017.
 */

class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "netwalkDatabase";

    // Contacts table name
    private static final String TABLE_HS = "highscore";

    // Contacts Table Columns names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String GAME = "level_number";
    private static final String SCORE = "clicks_done";
    private static final String TIMER = "time_needed";
    private final Context _context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        _context=context;

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_HS  + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT,"
                + GAME + " INTEGER, " + SCORE + " INTEGER, " + TIMER + " INTEGER" + ")";
        db.execSQL(createTable);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HS );

        // Create tables again
        onCreate(db);
    }

        //Allows me to drop the table if needed
    public void dropTable(){
        _context.deleteDatabase(DATABASE_NAME);

    }

    //Adds the player's score into the table
    public void addScore(playerInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, info.get_name());
        values.put(GAME, info.get_lvlChosen());
        values.put(SCORE, info.get_clicksDone());
        values.put(TIMER, info.get_time());

        db.insert(TABLE_HS , null, values);
    }

    /**
     * gets the player's score depending on which gamemode they are selected.
     * @param gameMode this is the game mode they have selected, for example 3 for 3x3 or 6 for 6x6
     * @return list of player scores
     */
    public List<playerInfo> getPlayers(int gameMode) {
        List<playerInfo> scores = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT *  FROM " + TABLE_HS + " WHERE " + GAME + "="+ gameMode + " ORDER BY " + SCORE + " ASC, "+ TIMER + " ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                playerInfo info = new playerInfo();
                info.set_name(cursor.getString(1));
                info.set_lvlChosen(Integer.parseInt(cursor.getString(2)));
                info.set_clicksDone(Integer.parseInt(cursor.getString(3)));
                info.set_time(Integer.parseInt(cursor.getString(4)));
                // Adding score into a list
                scores.add(info);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return score list
        return scores;
    }

}