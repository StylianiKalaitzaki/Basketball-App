package com.example.basketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;


public class Matches extends AppCompatActivity {
    private OkHttpHandler ok;
    private MatchesList ml;
    private ArrayList<Team> tm;
    private String myIP = "192.168.1.9";
    private final String rankingURL = "http://"+myIP+"/basketapp/getRanking.php";
    private ListView listView;
    private CustomListMatchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ok = new OkHttpHandler();
        try {
            tm = ok.populateRanking(rankingURL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        for(int i=0; i<tm.size(); i++) {
            System.out.println("Teams: " +tm.get(i).getName());
        }*/

        ml = new MatchesList(myIP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        getSupportActionBar().hide();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.matches);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.matches:
                        return true;
                    case R.id.ranking:
                        startActivity(new Intent(getApplicationContext(),Ranking.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        Spinner dropDown = (Spinner) findViewById(R.id.matches_spinner);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ml.getAllDays());
        dropDown.setAdapter(arrayAdapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String day = String.valueOf(dropDown.getSelectedItem());
                ArrayList<Match> matches = ml.getAllMatches(day);


                /* Testing
                for(int i=0; i<ml.getmList().size(); i++) {
                    if(ml.getmList().get(i).getDate()==date){
                       matches.add(ml.getmList().get(i));
                    }
                }*/
                /* Testing
                for(int i=0; i<matches.size(); i++) {
                    System.out.println("Matches: " +matches.get(i).getHomeTeam() +"-"+matches.get(i).getAwayTeam());
                }*/

                ArrayList<String> homeLogos = new ArrayList<>();
                ArrayList<String> awayLogos = new ArrayList<>();


                for(int i=0; i<matches.size(); i++) {
                    outloop1:
                    for(int j=0; j<tm.size(); j++) {
                        if(tm.get(j).getName().equals(matches.get(i).getHomeTeam())) {
                            homeLogos.add(tm.get(j).getLogo());
                            break outloop1;
                        }
                    }

                    outloop2:
                    for(int j=0; j<tm.size(); j++) {
                        if(tm.get(j).getName().equals(matches.get(i).getAwayTeam())) {
                            awayLogos.add(tm.get(j).getLogo());
                            break outloop2;
                        }
                    }
                }

                /*Testing
                for(int i=0; i<homeLogos.size(); i++) {
                    System.out.println("Home Logos: " +homeLogos.get(i));
                }

                for(int i=0; i<awayLogos.size(); i++) {
                    System.out.println("Away Logos: " +awayLogos.get(i));
                } */

                listView = (ListView) findViewById(R.id.listView);

                adapter = new CustomListMatchAdapter(getApplicationContext(), matches, homeLogos, awayLogos);
                listView.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }


}