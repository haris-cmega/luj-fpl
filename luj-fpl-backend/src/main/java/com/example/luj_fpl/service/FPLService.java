package com.example.luj_fpl.service;

import com.example.luj_fpl.client.FplAPIClient;
import com.example.luj_fpl.model.Event;
import com.example.luj_fpl.model.FPLResponse;
import org.springframework.stereotype.Service;

@Service
public class FPLService {

    private FplAPIClient fplAPIClient;

    public FPLService(FplAPIClient fplAPIClient){
        this.fplAPIClient = fplAPIClient;
    }

    public String getGameweekDeadline() {
        FPLResponse data = fplAPIClient.fetchFplData();

        for (Event event : data.getEvents()) {
            if (event.isNext.equals(true)) {
                return event.getDeadlineTime();
            }
        }
        return "Next gameweek not found... See you next season!";
    }


}
