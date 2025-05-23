package com.example.luj_fpl.model;

import java.util.List;

public class FPLResponse {
    private List<Event> events;
    private List<Team> teams;

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
}
