package com.example.regson.netwalkgame;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Creates the recycleview and displays the information on each card.
 * Created by Regson on 18/02/2017.
 */

public class HighscoreAdapter extends RecyclerView.Adapter<HighscoreAdapter.HighscoreViewholder> {


    private final List<playerInfo> playerList;

    public HighscoreAdapter(List<playerInfo>  playerList) {
        this.playerList =  playerList;
    }

    @Override
    public void onBindViewHolder(HighscoreViewholder viewHolder, int i) {
        playerInfo ci = playerList.get(i);
        viewHolder.txName.setText("Name: " + ci._name);
        viewHolder.txtMoves.setText("Moves: "+String.valueOf(ci._clicksDone));

        long timePassed = (ci._time);
        long timePassedMin = ((timePassed % 3600) / 60);
        long timePassedSec = (timePassed) % 60;
        String timeString = String.format(Locale.getDefault(),"%02d:%02d", timePassedMin, timePassedSec);
        viewHolder.txtTime.setText("Time taken: "+ timeString);

        String placeCounter;
        if (i==0){
            placeCounter ="1st";
        } else if (i==1){
            placeCounter ="2nd";
        }else if (i==2){
            placeCounter ="3rd";
        } else {
            placeCounter =(i+1)+"th";
        }
        viewHolder.txtPlace.setText(String.valueOf(placeCounter));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
    @Override
    public HighscoreViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card, viewGroup, false);
        return new HighscoreViewholder(itemView);
    }

    public class HighscoreViewholder extends RecyclerView.ViewHolder  {
        final TextView txName;
        final TextView txtMoves;
        final TextView txtTime;
        final TextView txtPlace;
        HighscoreViewholder(View v) {
            super(v);
            txName =  (TextView) v.findViewById(R.id.txtName);
            txtMoves = (TextView)  v.findViewById(R.id.txtMoves);
            txtTime = (TextView) v.findViewById(R.id.txtTime);
            txtPlace = (TextView) v.findViewById(R.id.txtPosition);
        }
    }
}
