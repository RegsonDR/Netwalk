package com.example.regson.netwalkgame;

/**
 * Creates object of playerinfo
 * Created by Regson on 17/02/2017.
 */

class playerInfo {
    String _name;
    private int _lvlChosen;
    int _clicksDone;
    int _time;


    public playerInfo(){

    }
    public playerInfo(String name, int levelChosen, int clicksDone, int time){
        this._name=name;
        this._lvlChosen=levelChosen;
        this._clicksDone=clicksDone;
        this._time=time;
    }

    public String get_name(){
        return this._name;
    }

    public void set_name(String name){
        this._name=name;
    }

    public int get_lvlChosen(){
        return this._lvlChosen;
    }

    public void set_lvlChosen(int lvlChosen){
        this._lvlChosen=lvlChosen;
    }

    public int get_clicksDone(){
        return this._clicksDone;
    }

    public void set_clicksDone(int clicksDone){
        this._clicksDone=clicksDone;
    }
    public int get_time(){
        return this._time;
    }

    public void set_time(int time){
        this._time=time;
    }
}
