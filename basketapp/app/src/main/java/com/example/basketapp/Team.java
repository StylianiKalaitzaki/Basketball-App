package com.example.basketapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable
{
    private String name;
    private int position;
    private String logo;
    private String leaguePoints;

    private String emblem;
    private List<String> players = new ArrayList<>();
    private String shots;
    private String shotsIn;
    private String twoP;
    private String twoPin;
    private String threeP;
    private String threePin;
    private String oneP;
    private String onePin;
    private String rebounds;
    private String assists;
    private String fouls;
    private String blocks;
    private String turnovers;
    private String points;
    private String steals;
    private String wins;
    private String defeats;
    private String totalGames;




    public Team(int pos, String log, String brand, String pts)
    {
        position = pos;
        logo = log;
        name = brand;
        leaguePoints = pts;
    }
    public Team(String name, String emblem)
    {
        this.name = name;
        this.emblem = emblem;
    }


    public boolean hasName(String b)
    {
        return name.equals(b);
    }
    public String getEmblem() {return emblem;}
    public String getName() {return name; }
    public List<String> getPlayers() { return this.players; }

    public void setShots(String shots) { this.shots = shots; }
    public void setShotsIn(String shotsIn) { this.shotsIn = shotsIn; }
    public void setTwoP(String twoP) { this.twoP = twoP; }
    public void setTwoPin(String twoPin) { this.twoPin = twoPin; }
    public void setThreeP(String threeP) { this.threeP = threeP; }
    public void setThreePin(String threePin) { this.threePin = threePin; }
    public void setOneP(String oneP) { this.oneP = oneP; }
    public void setOnePin(String onePin) { this.onePin = onePin; }
    public void setRebounds(String rebounds) { this.rebounds = rebounds; }
    public void setAssists(String assists) { this.assists = assists; }
    public void setFouls(String fouls) { this.fouls = fouls; }
    public void setBlocks(String blocks) { this.blocks = blocks; }
    public void setTurnovers(String turnovers) { this.turnovers = turnovers; }
    public void setPoints(String points) { this.points = points; }
    public void setSteals(String steals) { this.steals = steals; }
    public void setWins(String wins) { this.wins = wins; }
    public void setDefeats(String defeats) { this.defeats = defeats; }
    public void setTotalGames(String totalGames) { this.totalGames = totalGames; }

    public String getPosition() {
        return String.valueOf(position);
    }
    public String getLogo() {
        return logo;
    }
    public String getLeaguePoints() { return leaguePoints; }

    public String getShots() { return shots; }
    public String getShotsIn() { return shotsIn; }
    public String getTwoP() { return twoP; }
    public String getTwoPin() { return twoPin; }
    public String getThreeP() { return threeP; }
    public String getThreePin() { return threePin; }
    public String getOneP() { return oneP; }
    public String getOnePin() { return onePin; }
    public String getRebounds() { return rebounds; }
    public String getAssists() { return assists; }
    public String getFouls() { return fouls; }
    public String getBlocks() { return blocks; }
    public String getTurnovers() { return turnovers; }
    public String getPoints() { return points; }
    public String getSteals() { return steals; }
    public String getWins() { return wins; }
    public String getDefeats() { return defeats; }
    public String getTotalGames() { return totalGames; }
}
