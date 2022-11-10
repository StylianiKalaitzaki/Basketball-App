package com.example.basketapp;

import java.util.ArrayList;
import java.util.List;

public class MatchesList {

    ArrayList<Match> mList = new ArrayList<Match>();

    public MatchesList(String ip){
        String url="http://"+ip+"/basketapp/getMatches.php";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            mList = okHttpHandler.populateList(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Match> getmList() {
        return mList;
    }

    public List<String> getAllDays(){
        List<String> days= new ArrayList<String>();
        int i=0;
        for(Match m : mList){
            if(i < (Integer.parseInt(m.getDay()))){
                i++;
                days.add("League Day: " + String.valueOf(i));
            }
        }
        return days;
    }

    public ArrayList<Match> getAllMatches(String day){
        ArrayList<Match> temp = new ArrayList<Match>();
        for (Match m: mList) {
            if(("League Day: "+m.getDay()).equals(day)) {
                temp.add(m);
            }
        }
        return temp;
    }
}
