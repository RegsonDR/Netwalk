package com.example.regson.netwalkgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 *  This class draws the grid onto the screen and deals with the touch of each of the squares
 * Created by Regson on 01/02/2017
 */
public class GameView extends View {
    private final Bitmap cldr = BitmapFactory.decodeResource(this.getResources(), R.drawable.cldr);
    private final Bitmap clur = BitmapFactory.decodeResource(this.getResources(), R.drawable.clur);
    private final Bitmap culd = BitmapFactory.decodeResource(this.getResources(), R.drawable.culd);
    private final Bitmap curd = BitmapFactory.decodeResource(this.getResources(), R.drawable.curd);
    private final Bitmap ciHori = BitmapFactory.decodeResource(this.getResources(), R.drawable.cihori);
    private final Bitmap ciVert = BitmapFactory.decodeResource(this.getResources(), R.drawable.civert);
    private final Bitmap cLdown = BitmapFactory.decodeResource(this.getResources(), R.drawable.cldown);
    private final Bitmap cLleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.clleft);
    private final Bitmap cLright = BitmapFactory.decodeResource(this.getResources(), R.drawable.clright);
    private final Bitmap cLup = BitmapFactory.decodeResource(this.getResources(), R.drawable.clup);
    private final Bitmap cPCdown = BitmapFactory.decodeResource(this.getResources(), R.drawable.cpcdown);
    private final Bitmap cPCleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.cpcleft);
    private final Bitmap cPCright = BitmapFactory.decodeResource(this.getResources(), R.drawable.cpcright);
    private final Bitmap cPCup = BitmapFactory.decodeResource(this.getResources(), R.drawable.cpcup);
    private final Bitmap ldr = BitmapFactory.decodeResource(this.getResources(), R.drawable.ldr);
    private final Bitmap lur = BitmapFactory.decodeResource(this.getResources(), R.drawable.lur);
    private final Bitmap uld = BitmapFactory.decodeResource(this.getResources(), R.drawable.uld);
    private final Bitmap urd = BitmapFactory.decodeResource(this.getResources(), R.drawable.urd);
    private final Bitmap iHori = BitmapFactory.decodeResource(this.getResources(), R.drawable.ihori);
    private final Bitmap iVert = BitmapFactory.decodeResource(this.getResources(), R.drawable.ivert);
    private final Bitmap Ldown = BitmapFactory.decodeResource(this.getResources(), R.drawable.ldown);
    private final Bitmap Lleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.lleft);
    private final Bitmap Lright = BitmapFactory.decodeResource(this.getResources(), R.drawable.lright);
    private final Bitmap Lup = BitmapFactory.decodeResource(this.getResources(), R.drawable.lup);
    private final Bitmap PCdown = BitmapFactory.decodeResource(this.getResources(), R.drawable.pcdown);
    private final Bitmap PCleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.pcleft);
    private final Bitmap PCright = BitmapFactory.decodeResource(this.getResources(), R.drawable.pcright);
    private final Bitmap PCup = BitmapFactory.decodeResource(this.getResources(), R.drawable.pcup);
    private final Bitmap serverD = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverdown);
    private final Bitmap serverU = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverup);
    private final Bitmap serverL = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverleft);
    private final Bitmap serverR = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverright);
    private final Bitmap serverul = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverul);
    private final Bitmap serverlr = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverlr);
    private final Bitmap serverld = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverld);
    private final Bitmap serverur = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverur);
    private final Bitmap serverud = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverud);
    private final Bitmap serverldr = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverldr);
    private final Bitmap serverlur = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverlur);
    private final Bitmap serveruld = BitmapFactory.decodeResource(this.getResources(), R.drawable.serveruld);
    private final Bitmap serverdr = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverdr);
    private final Bitmap serverurd = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverurd);
    private final Bitmap serverldur = BitmapFactory.decodeResource(this.getResources(), R.drawable.serverldur);

    private final Bitmap bldr = BitmapFactory.decodeResource(this.getResources(), R.drawable.bldr);
    private final Bitmap blur = BitmapFactory.decodeResource(this.getResources(), R.drawable.blur);
    private final Bitmap buld = BitmapFactory.decodeResource(this.getResources(), R.drawable.buld);
    private final Bitmap burd = BitmapFactory.decodeResource(this.getResources(), R.drawable.burd);
    private final Bitmap biHori = BitmapFactory.decodeResource(this.getResources(), R.drawable.bihori);
    private final Bitmap biVert = BitmapFactory.decodeResource(this.getResources(), R.drawable.bivert);
    private final Bitmap bLdown = BitmapFactory.decodeResource(this.getResources(), R.drawable.bldown);
    private final Bitmap bLleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.blleft);
    private final Bitmap bLright = BitmapFactory.decodeResource(this.getResources(), R.drawable.blright);
    private final Bitmap bLup = BitmapFactory.decodeResource(this.getResources(), R.drawable.blup);
    private final Bitmap bPCdown = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpcdown);
    private final Bitmap bPCleft = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpcleft);
    private final Bitmap bPCright = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpcright);
    private final Bitmap bPCup = BitmapFactory.decodeResource(this.getResources(), R.drawable.bpcup);
    private final Bitmap bserverD = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverdown);
    private final Bitmap bserverU = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverup);
    private final Bitmap bserverL = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverleft);
    private final Bitmap bserverR = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverright);
    private final Bitmap bserverul = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverul);
    private final Bitmap bserverlr = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverlr);
    private final Bitmap bserverld = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverld);
    private final Bitmap bserverur = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverur);
    private final Bitmap bserverud = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverud);
    private final Bitmap bserverldr = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverldr);
    private final Bitmap bserverlur = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverlur);
    private final Bitmap bserveruld = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserveruld);
    private final Bitmap bserverdr = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverdr);
    private final Bitmap bserverurd = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverurd);
    private final Bitmap bserverldur = BitmapFactory.decodeResource(this.getResources(), R.drawable.bserverldur);

    private int sqSizeh;
    private int sqSizew;
    private final Context appContext;
    static boolean won;
    static Chronometer timer;
    private static long timePassed;
    static String pName;
    static boolean themeBlue;
    private final DatabaseHandler db;
    private String nameplayer;
    private boolean isTouchable= true;
    private static int clickcount;
    private final NetwalkGrid mGame;

    public GameView(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.appContext = context;
            db = new DatabaseHandler(appContext);
            init();
            mGame = new NetwalkGrid(GameActivity.DEFAULT_COLUMNS, GameActivity.DEFAULT_ROWS);
        GestureDetector mGestureDetector = new GestureDetector(context, new GestureListener());
    }

     /**
     * sets the timer up
     */
     private void setChrono(){
        timer=(Chronometer) ((Activity) appContext).findViewById(R.id.chronometer);
        timer.setBase(SystemClock.elapsedRealtime()+timePassed);
        timer.start();
    }

    /**
     * calculates which column was clicked on
     * @param event event
     * @return x position
     */
    private int getColumn(MotionEvent event){
        if (sqSizeh>sqSizew) {
            int singlecolumnlength = sqSizew;
            float columnSelected = event.getX() / singlecolumnlength;
            return (int) columnSelected;
        } else {
            int singlecolumnlength = sqSizeh;
            float columnSelected = event.getX() / singlecolumnlength;
            return (int) columnSelected;
        }
    }
    /**
     * calculates which row was clicked on
     * @param event event
     * @return y position
     */
    private int getRow(MotionEvent event){
        if (sqSizeh>sqSizew) {
            int singlecolumnlength = sqSizew;
            float dx = (event.getY() / singlecolumnlength);
            return (int) dx;
        } else {
            int singlecolumnlength = sqSizeh;
            float dx = (event.getY() / singlecolumnlength);
            return (int) dx;
        }
    }

    /**
     * increments the move counter
     */
    private void incr(){
    clickcount++;
        TextView txtView = (TextView) ((Activity) appContext).findViewById(R.id.txtmoveCounter);
        txtView.setText("Moves: " + clickcount);
}

    /**
     * this method deals with all the clicks onto the grid, clicks outside the grid are ignored
     * @param event event
     * @return clicked on
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)   {
        if (isTouchable) {
            if (sqSizeh > sqSizew) {
                if ((event.getY() < ((sqSizew) * GameActivity.DEFAULT_ROWS)) && (event.getX() < ((sqSizeh) * GameActivity.DEFAULT_ROWS))) {
                    mGame.rotateRight(getColumn(event), getRow(event));
                    incr();
                    invalidate();
                    gameWon();
                    return super.onTouchEvent(event);
                }
            }
        }
       return false;
    }
    private void init() {
        won = false;
        isTouchable = true;
        clickcount = 0;
        timePassed = 0;
        setChrono();
    }

    /**
     *draws the grid onto the screen
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for (int row = 0; row < GameActivity.DEFAULT_ROWS; row++) {
            for (int col = 0; col < GameActivity.DEFAULT_COLUMNS; col++) {

                int cellContent = mGame.getGridElem(col, row);
                sqSizew = getWidth() / (GameActivity.DEFAULT_COLUMNS);
                sqSizeh = getHeight() / (GameActivity.DEFAULT_COLUMNS);
                int bottomRightY;
                int bottomRightX;
                int topLeftY;
                int topLeftX;
                if (sqSizeh > sqSizew) {
                    topLeftX = (col) * sqSizew;
                    topLeftY = (row) * sqSizew;
                    bottomRightX = ((col) * sqSizew) + sqSizew;
                    bottomRightY = ((row) * sqSizew) + sqSizew;
                } else {
                    topLeftX = (col) * sqSizeh;
                    topLeftY = (row) * sqSizeh;
                    bottomRightX = ((col) * sqSizeh) + sqSizeh;
                    bottomRightY = ((row) * sqSizeh) + sqSizeh;
                }

                if (themeBlue) {
                    if (cellContent == 95) {
                        canvas.drawBitmap(bserverldur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 92) {
                        canvas.drawBitmap(bserverul, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 90) {
                        canvas.drawBitmap(bserverlr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 89) {
                        canvas.drawBitmap(bserverld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 86) {
                        canvas.drawBitmap(bserverur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 85) {
                        canvas.drawBitmap(bserverud, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 83) {
                        canvas.drawBitmap(bserverdr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 94) {
                        canvas.drawBitmap(bserverlur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 93) {
                        canvas.drawBitmap(bserveruld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 91) {
                        canvas.drawBitmap(bserverldr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 87) {
                        canvas.drawBitmap(bserverurd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 40) {
                        canvas.drawBitmap(bPCleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 36) {
                        canvas.drawBitmap(bPCup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 34) {
                        canvas.drawBitmap(bPCright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 33) {
                        canvas.drawBitmap(bPCdown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 12) {
                        canvas.drawBitmap(bLleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 10) {
                        canvas.drawBitmap(biHori, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 9) {
                        canvas.drawBitmap(bLdown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 6) {
                        canvas.drawBitmap(bLup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 5) {
                        canvas.drawBitmap(biVert, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 3) {
                        canvas.drawBitmap(bLright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 14) {
                        canvas.drawBitmap(blur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 13) {
                        canvas.drawBitmap(buld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 11) {
                        canvas.drawBitmap(bldr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 7) {
                        canvas.drawBitmap(burd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 88) {
                        canvas.drawBitmap(bserverL, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 84) {
                        canvas.drawBitmap(bserverU, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 82) {
                        canvas.drawBitmap(bserverR, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                    if (cellContent == 81) {
                        canvas.drawBitmap(bserverD, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                    }
                } else {
                if (cellContent == 95) {
                    canvas.drawBitmap(serverldur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 92) {
                    canvas.drawBitmap(serverul, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 90) {
                    canvas.drawBitmap(serverlr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 89) {
                    canvas.drawBitmap(serverld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 86) {
                    canvas.drawBitmap(serverur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 85) {
                    canvas.drawBitmap(serverud, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 83) {
                    canvas.drawBitmap(serverdr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 94) {
                    canvas.drawBitmap(serverlur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 93) {
                    canvas.drawBitmap(serveruld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 91) {
                    canvas.drawBitmap(serverldr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 87) {
                    canvas.drawBitmap(serverurd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 40) {
                    canvas.drawBitmap(PCleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 36) {
                    canvas.drawBitmap(PCup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 34) {
                    canvas.drawBitmap(PCright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 33) {
                    canvas.drawBitmap(PCdown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 12) {
                    canvas.drawBitmap(Lleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 10) {
                    canvas.drawBitmap(iHori, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 9) {
                    canvas.drawBitmap(Ldown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 6) {
                    canvas.drawBitmap(Lup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 5) {
                    canvas.drawBitmap(iVert, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 3) {
                    canvas.drawBitmap(Lright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 14) {
                    canvas.drawBitmap(lur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 13) {
                    canvas.drawBitmap(uld, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 11) {
                    canvas.drawBitmap(ldr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 7) {
                    canvas.drawBitmap(urd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 88) {
                    canvas.drawBitmap(serverL, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 84) {
                    canvas.drawBitmap(serverU, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 82) {
                    canvas.drawBitmap(serverR, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 81) {
                    canvas.drawBitmap(serverD, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 104) {
                    canvas.drawBitmap(cPCleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 100) {
                    canvas.drawBitmap(cPCup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 98) {
                    canvas.drawBitmap(cPCright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 97) {
                    canvas.drawBitmap(cPCdown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 76) {
                    canvas.drawBitmap(cLleft, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 74) {
                    canvas.drawBitmap(ciHori, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 73) {
                    canvas.drawBitmap(cLdown, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 70) {
                    canvas.drawBitmap(cLup, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 69) {
                    canvas.drawBitmap(ciVert, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 67) {
                    canvas.drawBitmap(cLright, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 78) {
                    canvas.drawBitmap(clur, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 77) {
                    canvas.drawBitmap(culd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 75) {
                    canvas.drawBitmap(cldr, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                if (cellContent == 71) {
                    canvas.drawBitmap(curd, null, new Rect(topLeftX, topLeftY, bottomRightX, bottomRightY), null);
                }
                }
            }
        }
    }
    /**
     *adds the player score into database if they selected "ok" option
     */
    private void insertdb(){
        db.addScore(new playerInfo(nameplayer, GameActivity.DEFAULT_COLUMNS, clickcount, (int) timePassed));
    }
    /**
     * after the game is won a dialog alert is shown to add score to database
     */
    private void gameWon(){
        if (won) {
            timePassed = (SystemClock.elapsedRealtime() - timer.getBase())/1000;
            long timePassedMin = ((timePassed % 3600) / 60);
            long timePassedSec = (timePassed) % 60;
            String timeString = String.format(Locale.getDefault(), "%02d:%02d", timePassedMin, timePassedSec);
            isTouchable=false;
            View v = (LayoutInflater.from(getContext())).inflate(R.layout.winner_screen, null);
            AlertDialog.Builder alterB = new AlertDialog.Builder(getContext());
            alterB.setView(v);
            alterB.setTitle("Save score? Clicks: "+clickcount+" Time: " + timeString);
            final EditText userinp = (EditText) v.findViewById(R.id.userinput);
            userinp.setText(pName);
            alterB.setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            nameplayer=userinp.getText().toString();
                            insertdb();
                            Toast.makeText(getContext(), "Score saved!", Toast.LENGTH_LONG).show();

                        }
                    });
            alterB.setNegativeButton("cancel", null );
            alterB.setNeutralButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Activity activity = (Activity) appContext;
                    activity.finish();
                }
            });
            Dialog dia = alterB.create();
            dia.show();
        }
    }

}