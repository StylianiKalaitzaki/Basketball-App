package com.example.basketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity
{
    private OkHttpHandler ok;
    private ListView listView;
    private CustomListAdapter adapter;
    private ArrayList<Team> rankingList;
    private final String myIP = "192.168.1.9";
    private final String rankingURL = "http://"+myIP+"/basketapp/getRanking.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ok = new OkHttpHandler();
        try {
            rankingList = ok.populateRanking(rankingURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.ranking);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ranking:
                        return true;
                    case R.id.matches:
                        startActivity(new Intent(getApplicationContext(),Matches.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        adapter = new CustomListAdapter(getApplicationContext(), rankingList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Team tm = (Team) parent.getAdapter().getItem(position);

                openStatistics(tm);
            }
        });
    }
    public void openStatistics(Team tm)
    {
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.putExtra("TEAM", tm);
        startActivity(intent);
    }

}