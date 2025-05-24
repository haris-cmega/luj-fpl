package com.example.luj_fpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FPLResponse {
    private List<Event> events;
    private List<Team> teams;
    @JsonProperty("elements")
    private List<Player> players;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
