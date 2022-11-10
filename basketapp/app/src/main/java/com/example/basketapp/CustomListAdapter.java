package com.example.basketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    private  Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Team> rankingR;
    private Team teamModel;
    private final int LOGOSIZE = 50;



    public CustomListAdapter(Context context, ArrayList<Team> rankingR) {
        this.mContext = context;
        this.rankingR = rankingR;
        //layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return rankingR.size();
    }

    @Override
    public Object getItem(int i) {
        return rankingR.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView==null) {
            //rowView = layoutInflater.inflate(R.layout.ranking_row, null, true);
            rowView = LayoutInflater.from(mContext).
                    inflate(R.layout.ranking_row, null);
        }
        TextView position = rowView.findViewById(R.id.position);
        ImageView teamLogo = rowView.findViewById(R.id.teamLogo);
        TextView teamName = rowView.findViewById(R.id.teamName);
        TextView points = rowView.findViewById(R.id.points);
        teamModel = rankingR.get(pos);
        position.setText(teamModel.getPosition());
        Picasso.with(mContext).load(teamModel.getLogo()).resize(LOGOSIZE,LOGOSIZE).into(teamLogo);
        teamName.setText(teamModel.getName());
        points.setText(teamModel.getLeaguePoints());
        return rowView;
    }
}
