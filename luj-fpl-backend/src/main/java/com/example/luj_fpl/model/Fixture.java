package com.example.luj_fpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fixture {
    private int id;

    @JsonProperty("team_h")
    private int homeTeam;

    @JsonProperty("team_a")
    private int awayTeam;

    @JsonProperty("team_h_score")
    private Integer homeTeamScore;

    @JsonProperty("team_a_score")
    private Integer awayTeamScore;

    @JsonProperty("event")
    private int gameweek;

    @JsonProperty("kickoff_time")
    private String kickOffTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getGameweek() {
        return gameweek;
    }

    public void setGameweek(int gameweek) {
        this.gameweek = gameweek;
    }

    public String getKickOffTime() {
        return kickOffTime;
    }

    public void setKickOffTime(String kickOffTime) {
        this.kickOffTime = kickOffTime;
    }
}
