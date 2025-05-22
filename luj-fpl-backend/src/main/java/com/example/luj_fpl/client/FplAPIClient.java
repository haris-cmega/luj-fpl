package com.example.luj_fpl.client;

import com.example.luj_fpl.model.FPLResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FplAPIClient {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fantasy.premierleague.com/api/bootstrap-static/";

    public FPLResponse fetchFplData(){
        return restTemplate.getForObject(url, FPLResponse.class);
    }

}
