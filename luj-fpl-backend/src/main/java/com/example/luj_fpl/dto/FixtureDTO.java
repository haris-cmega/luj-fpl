package com.example.luj_fpl.dto;

public class FixtureDTO {
    private String homeTeam;
    private String awayTeam;
    private String kickOffTime;

    public FixtureDTO(){

    }

    public FixtureDTO(String homeTeam, String awayTeam, String kickOffTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.kickOffTime = kickOffTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getKickOffTime() {
        return kickOffTime;
    }

    public void setKickOffTime(String kickOffTime) {
        this.kickOffTime = kickOffTime;
    }
}
