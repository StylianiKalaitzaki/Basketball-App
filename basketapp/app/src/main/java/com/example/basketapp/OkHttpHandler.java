package com.example.basketapp;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler
{
    public OkHttpHandler()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public ArrayList<Team> getTeamsDetails(String url) throws Exception
    {

        ArrayList<Team> tml = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("+++++++++++My Response: " + data);

        try
        {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext())
            {
                String team = keys.next();
                String emblem = json.getJSONObject(team).getString("logo");
                tml.add(new Team(team,emblem));
            }
        } catch (JSONException e) { e.printStackTrace(); }

        return tml;
    }

    /*Different url from above, different php file*/
    //public TeamStatistics getTeamsStats(String url) throws Exception
    public void getTeamsStats(String url,Team tm) throws Exception
    {
        //TeamStatistics tm = null;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("+++++++++++My Response: " + data);

        try
        {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            //while(keys.hasNext())
            //{
                String team = keys.next();
                String games = json.getJSONObject(team).getString("Games");
                String Shots = json.getJSONObject(team).getString("Shots");
                String ShotsIn = json.getJSONObject(team).getString("ShotsIn");
                String oneP = json.getJSONObject(team).getString("1P");
                String onePin = json.getJSONObject(team).getString("1P_IN");
                String twoP = json.getJSONObject(team).getString("2P");
                String twoPin = json.getJSONObject(team).getString("2P_IN");
                String threeP = json.getJSONObject(team).getString("3P");
                String threePin = json.getJSONObject(team).getString("3P_IN");
                String rebounds = json.getJSONObject(team).getString("Rebounds");
                String assists = json.getJSONObject(team).getString("Assists");
                String steals = json.getJSONObject(team).getString("Steals");
                String blocks = json.getJSONObject(team).getString("Blocks");
                String fouls = json.getJSONObject(team).getString("Fouls");
                String points = json.getJSONObject(team).getString("Points");
                String turnovers = json.getJSONObject(team).getString("Turnovers");
                String wins = json.getJSONObject(team).getString("Wins");
                String defeats = json.getJSONObject(team).getString("Defeats");

                tm.setTotalGames(games);
                tm.setWins(wins);
                tm.setDefeats(defeats);
                tm.setShotsIn(ShotsIn);
                tm.setShots(Shots);
                tm.setTwoP(twoP);
                tm.setTwoPin(twoPin);
                tm.setThreeP(threeP);
                tm.setThreePin(threePin);
                tm.setOneP(oneP);
                tm.setOnePin(onePin);
                tm.setRebounds(rebounds);
                tm.setAssists(assists);
                tm.setBlocks(blocks);
                tm.setFouls(fouls);
                tm.setSteals(steals);
                tm.setPoints(points);
                tm.setTurnovers(turnovers);
                //tm = new TeamStatistics(team,Shots,ShotsIn,twoP,twoPin,threeP,threePin,oneP,onePin,rebounds,assists,fouls,blocks,steals,points,turnovers);
          //}
        } catch (JSONException e) { e.printStackTrace(); }

        //return tm;
    }

    public ArrayList<Player> getPlayers(String url) {
        ArrayList<Player> playerList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();
        Response response;

        String data = null;
        try {
            response = client.newCall(request).execute();
            data = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String playerId = keys.next();
                String teamName = json.getJSONObject(playerId).getString("teamName").toString();
                String firstname = json.getJSONObject(playerId).getString("firstname").toString();
                String lastname = json.getJSONObject(playerId).getString("lastname").toString();
                String position = json.getJSONObject(playerId).getString("position").toString();
                JSONObject statistics = json.getJSONObject(playerId).getJSONObject("statistics");
                playerList.add(new Player(firstname,lastname,position, statistics, playerId, teamName));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    ArrayList<Team> populateRanking(String url) throws Exception {

        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();
        Response response;

        String data = null;
        try {
            response = client.newCall(request).execute();
            data = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        ArrayList<Team> rankingList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My Response: " + data);
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            int i = 0;
            while(keys.hasNext()) {
                i++;
                int position = i;
                String brand = keys.next();
                String logo = json.getJSONObject(brand).getString("logo");
                String points = json.getJSONObject(brand).getString("points");
                rankingList.add(new Team(position,logo,brand,points));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i=0; i< rankingList.size(); i++) {
            System.out.println(rankingList.get(i).getPosition() + rankingList.get(i).getName() + rankingList.get(i).getLogo() + rankingList.get(i).getLeaguePoints());
        }
        return rankingList;
    }
    ArrayList<Match> populateList(String url) throws Exception {
        ArrayList<Match> mList = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
//        System.out.println("My Response: " + data);
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                String id = keys.next();

                String homeTeam = json.getJSONObject(id).getString("homeTeam");
                String awayTeam = json.getJSONObject(id).getString("awayTeam");
                String score = json.getJSONObject(id).getString("score");
                String day = json.getJSONObject(id).getString("day");
                String date = json.getJSONObject(id).getString("date");

                mList.add(new Match(homeTeam, awayTeam,date,day,score));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }
}

