package com.example.luj_fpl.dto;

public class PlayerTransferDTO {
    private String name;
    private double price;
    private int totalPoints;
    private int transfers;

    public PlayerTransferDTO(String name, double price, int totalPoints, int transfers) {
        this.name = name;
        this.price = price;
        this.totalPoints = totalPoints;
        this.transfers = transfers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTransfers() {
        return transfers;
    }

    public void setTransfers(int transfers) {
        this.transfers = transfers;
    }
}
