package com.example.luj_fpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    private int id;
    private String name;

    @JsonProperty("deadline_time")
    private String deadlineTime;

    @JsonProperty("is_next")
    public Boolean isNext;

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

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Boolean getNext() {
        return isNext;
    }

    public void setNext(Boolean next) {
        isNext = next;
    }
}
