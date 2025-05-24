package com.example.luj_fpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

    private int id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("transfers_in_event")
    private int transfersInEvent;

    @JsonProperty("transfers_out_event")
    private int transfersOutEvent;

    @JsonProperty("now_cost")
    private int nowCost;

    @JsonProperty("total_points")
    private int totalPoints;

    public Player() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getTransfersInEvent() {
        return transfersInEvent;
    }

    public void setTransfersInEvent(int transfersInEvent) {
        this.transfersInEvent = transfersInEvent;
    }

    public int getTransfersOutEvent() {
        return transfersOutEvent;
    }

    public void setTransfersOutEvent(int transfersOutEvent) {
        this.transfersOutEvent = transfersOutEvent;
    }

    public int getNowCost() {
        return nowCost;
    }

    public void setNowCost(int nowCost) {
        this.nowCost = nowCost;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
