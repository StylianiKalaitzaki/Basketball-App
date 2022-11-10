package com.example.basketapp;

import org.json.JSONObject;

public class Player {
    private String firstName;
    private String lastname;
    private String position;
    private String id;
    private String teamName;
    private JSONObject statistics;

    public Player(String firstName, String lastname, String position, JSONObject statistics, String id, String teamName) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.position = position;
        this.id = id;
        this.teamName = teamName;
        this.statistics = statistics;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    public String getPlayerId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public JSONObject getStatistics() {
        return statistics;
    }

}
