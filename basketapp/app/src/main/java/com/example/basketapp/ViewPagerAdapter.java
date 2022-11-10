package com.example.basketapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter
{

    private Team team;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,Team team) {
        super(fragmentActivity);
        this.team=team;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch(position)
        {
            case 1:
                return new PlayerStats(team);
            default:
                return new TeamStats(team);
        }
    }

    @Override
    public int getItemCount() { return 2;}
}
