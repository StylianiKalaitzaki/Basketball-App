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

public class CustomListMatchAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<Match> matchM;
    private ArrayList<String> hLogo;
    private ArrayList<String> aLogo;
    private Match matchModel;
    private final int LOGOSIZE = 130;



    public CustomListMatchAdapter(Context context, ArrayList<Match> matchM,  ArrayList<String> hLogo, ArrayList<String> aLogo) {
        this.mContext = context;
        this.matchM = matchM;
        this.hLogo = hLogo;
        this.aLogo = aLogo;
        //layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return matchM.size();
    }

    @Override
    public Object getItem(int i) {
        return matchM.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView==null) {
            //rowView = layoutInflater.inflate(R.layout.match_row, null, true);
            rowView = LayoutInflater.from(mContext).
                    inflate(R.layout.match_row, null);
        }
        ImageView homeTeamImage = rowView.findViewById(R.id.homeTeamImage);
        TextView vs = rowView.findViewById(R.id.vs);
        TextView date = rowView.findViewById(R.id.date);
        ImageView awayTeamImage = rowView.findViewById(R.id.awayTeamImage);
        matchModel = matchM.get(position);
        Picasso.with(mContext).load(hLogo.get(position)).resize(LOGOSIZE,LOGOSIZE).into(homeTeamImage);
        vs.setText("VS");
        date.setText(matchModel.getDate());
        Picasso.with(mContext).load(aLogo.get(position)).resize(LOGOSIZE,LOGOSIZE).into(awayTeamImage);
        return rowView;
    }

}
