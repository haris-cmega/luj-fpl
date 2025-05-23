package com.example.luj_fpl.client;

import com.example.luj_fpl.model.FPLResponse;
import com.example.luj_fpl.model.Fixture;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FplAPIClient {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fantasy.premierleague.com/api/bootstrap-static/";
    String fixturesUrl = "https://fantasy.premierleague.com/api/fixtures/";

    public FPLResponse fetchFplData(){
        return restTemplate.getForObject(url, FPLResponse.class);
    }

    public List<Fixture> fetchFixturesForGameweek(int gameweek) {
        String url = fixturesUrl + "?event=" + gameweek;

        ResponseEntity<List<Fixture>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Fixture>>() {}
        );

        return response.getBody();
    }
}
