package com.example.basketapp;

public class Match {

    private String homeTeam;
    private String awayTeam;
    private String date;
    private String day;
    private String score;


    public Match(String hTeam, String aTeam, String otherDate, String otherDay, String s) {
        this.homeTeam=hTeam;
        this.awayTeam=aTeam;
        this.day=otherDay;
        this.date=otherDate;
        this.score=s;
    }

    public String getHomeTeam(){
        return this.homeTeam;
    }

    public String getAwayTeam(){
        return this.awayTeam;
    }

    public String getDay(){
        return this.day;
    }

    public String getDate() {return this.date;}

    public String getTime(){
        String[] temp=getDate().replaceAll(" ","X").split("X");
        return temp[1].substring(0,5);
    }

    public String getScore(){
        return this.homeTeam;
    }

    public String getMatchToString(){
        return score+"\n"+getTime();
    }

}
