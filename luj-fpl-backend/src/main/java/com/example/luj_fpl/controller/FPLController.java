package com.example.luj_fpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.util.*;

@RestController
public class FPLController {

    @GetMapping("/current-fixtures")
    public List<Map<String, Object>> fetchCurrentGameweekFixtures() {
        RestTemplate restTemplate = new RestTemplate();

        // Here we get the current GW ID
        String bootstrapUrl = "https://fantasy.premierleague.com/api/bootstrap-static/";
        String bootstrapJson = restTemplate.getForObject(bootstrapUrl, String.class);
        JSONObject bootstrapData = new JSONObject(bootstrapJson);
        JSONArray events = bootstrapData.getJSONArray("events");

        int currentGw = -1;
        for (int i = 0; i < events.length(); i++) {
            JSONObject gw = events.getJSONObject(i);
            if (gw.getBoolean("is_current")) {
                currentGw = gw.getInt("id");
                break;
            }
        }

        // Get teams for ID-to-name mapping
        JSONArray teamsArray = bootstrapData.getJSONArray("teams");
        Map<Integer, String> teamIdToName = new HashMap<>();
        for (int i = 0; i < teamsArray.length(); i++) {
            JSONObject team = teamsArray.getJSONObject(i);
            teamIdToName.put(team.getInt("id"), team.getString("name"));
        }

        // Fetch all fixtures
        String fixturesUrl = "https://fantasy.premierleague.com/api/fixtures/";
        String fixturesJson = restTemplate.getForObject(fixturesUrl, String.class);
        JSONArray allFixtures = new JSONArray(fixturesJson);

        List<Map<String, Object>> simplifiedFixtures = new ArrayList<>();
        for (int i = 0; i < allFixtures.length(); i++) {
            JSONObject fixture = allFixtures.getJSONObject(i);
            if (fixture.has("event") && fixture.getInt("event") == currentGw) {
                Map<String, Object> match = new HashMap<>();
                match.put("gameweek", fixture.optInt("event", -1));
                match.put("kickoff_time", fixture.optString("kickoff_time"));
                match.put("home_team", teamIdToName.getOrDefault(fixture.getInt("team_h"), "Unknown"));
                match.put("away_team", teamIdToName.getOrDefault(fixture.getInt("team_a"), "Unknown"));
                match.put("home_score", fixture.optInt("team_h_score", -1));
                match.put("away_score", fixture.optInt("team_a_score", -1));
                match.put("finished", fixture.getBoolean("finished"));
                simplifiedFixtures.add(match);
            }
        }

        return simplifiedFixtures;
    }
}
