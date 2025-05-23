package com.example.luj_fpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
    private int id;
    private String name;

    @JsonProperty("short_name")
    private String shortName;

    public Team(){

    }

    public Team(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
