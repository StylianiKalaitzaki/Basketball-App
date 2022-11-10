package com.example.basketapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamStats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamStats extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private final String myIP = "192.168.1.9";
    //private String team="Panathinaikos";
    private StatisticsActivity mActivity;
    private Team team;

    public TeamStats()
    { }
    public TeamStats(Team t)
    {
        this.team=t;
        String url= "http://"+myIP+"/basketapp/getTeamStats.php?team='"+team.getName()+"'";

        try
        {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            okHttpHandler.getTeamsStats(url,team);

        } catch (Exception e) { e.printStackTrace(); }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamStats.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamStats newInstance(String param1, String param2) {
        TeamStats fragment = new TeamStats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_stats, container, false);

        TextView games = view.findViewById(R.id.gamesTextView);
        games.setText(team.getTotalGames());

        TextView wins = view.findViewById(R.id.winsTextView);
        wins.setText(team.getWins());

        TextView defeats = (TextView)view.findViewById(R.id.defeatsTextView);
        defeats.setText(team.getDefeats());

        TextView shots = (TextView)view.findViewById(R.id.ShotsTextView);
        shots.setText(team.getShotsIn()+" / "+team.getShots());

        TextView oneP = (TextView)view.findViewById(R.id.textView1P);
        oneP.setText(team.getOnePin()+" / "+team.getOneP());

        TextView twoP = (TextView)view.findViewById(R.id.textView2P);
        twoP.setText(team.getTwoPin()+" / "+team.getTwoP());

        TextView threeP = (TextView)view.findViewById(R.id.textView3P);
        threeP.setText(team.getThreePin()+" / "+team.getThreeP());

        TextView rebounds = (TextView)view.findViewById(R.id.ReboundsTextView);
        rebounds.setText(team.getRebounds());

        TextView assists = (TextView)view.findViewById(R.id.AssistsTextView);
        assists.setText(team.getAssists());

        TextView Steals = (TextView)view.findViewById(R.id.StealsTextView);
        Steals.setText(team.getSteals());

        TextView blocks = (TextView)view.findViewById(R.id.BlocksTextView);
        blocks.setText(team.getBlocks());

        TextView fouls = (TextView)view.findViewById(R.id.FoulsTextView);
        fouls.setText(team.getFouls());

        TextView turnovers = (TextView)view.findViewById(R.id.TurnoversTextView);
        turnovers.setText(team.getTurnovers());

        TextView points = (TextView)view.findViewById(R.id.PointsTextView);
        points.setText(team.getPoints());

        return view;
    }

}