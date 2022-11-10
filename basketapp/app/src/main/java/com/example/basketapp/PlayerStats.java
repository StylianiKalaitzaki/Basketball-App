package com.example.basketapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerStats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerStats extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<Player> playerList = new ArrayList<>();
    private Team team;
    private final String myIP = "192.168.1.9";
    RecyclerView recyclerView;
    PlayerAdapter adapter;
    private String mParam1;
    private String mParam2;
    public PlayerStats() {
    }

    public PlayerStats(Team t) {

        this.team = t;
        String url= "http://"+myIP+"/basketapp/getPlayers.php?teamName='"+team.getName()+"'";
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            playerList = okHttpHandler.getPlayers(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayerStats.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerStats newInstance(String param1, String param2) {
        PlayerStats fragment = new PlayerStats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layouts[] = new LinearLayout[2];
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_stats, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new PlayerAdapter(view.getContext(), playerList);
        recyclerView.setAdapter(adapter);


        return view;
    }


}