package com.example.basketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

public class StatisticsActivity extends AppCompatActivity {
    private final int EMBLEMSIZE = 150;
    private final String myIP = "192.168.1.9";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Retrieve data from R7*/
        Intent intent = getIntent();
        Team teamObj = (Team) intent.getSerializableExtra("TEAM");
        System.out.println("Team: " + teamObj.getName());
        System.out.println("Logo: " + teamObj.getLogo());

        /*For testing without R7*/
        //Team teamObj = new Team("Panathinaikos","https:\\/upload.wikimedia.org\\/wikipedia\\/en\\/thumb\\/1\\/18\\/Panathinaikos_BC_logo.svg\\/1200px-Panathinaikos_BC_logo.svg.png");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setElevation(0);

        ImageView teamImage = findViewById(R.id.teamEmblem);

        Picasso.with(this).load(teamObj.getLogo()).resize(EMBLEMSIZE, 0).into(teamImage);


        //< get elements >
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        //</ get elements>


        ViewPagerAdapter adapter = new ViewPagerAdapter(this, teamObj);
        viewPager2.setAdapter(adapter);
        viewPager2.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {

                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0)
                            tab.setText("Team Stats");
                        else if (position == 1)
                            tab.setText("Player Stats");
                        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

                    }
                }).attach();

    }

}