package com.example.luj_fpl.service;

import com.example.luj_fpl.client.FplAPIClient;
import com.example.luj_fpl.dto.FixtureDTO;
import com.example.luj_fpl.dto.PlayerTransferDTO;
import com.example.luj_fpl.model.*;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
        return null;
    }

    public List<FixtureDTO> getNextGameweekFixtures() {
        FPLResponse data = fplAPIClient.fetchFplData();
        List<Team> teams = data.getTeams();

        Map<Integer, String> teamIdToName = new HashMap<>();
        for (Team team : teams) {
            teamIdToName.put(team.getId(), team.getName());
        }

        int gameweekId = -1;
        for (Event event : data.getEvents()) {
            if (event.isNext.equals(true)) {
                gameweekId = event.getId();
                break;
            }
        }

//        if (gameweekId == -1) return new ArrayList<>();

        List<Fixture> fixtures = fplAPIClient.fetchFixturesForGameweek(gameweekId);

        List<FixtureDTO> fixtureDTOs = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy HH:mm")
                .withZone(ZoneId.of("Europe/Tirane"));

        for (Fixture fixture : fixtures) {
            String homeTeamName = teamIdToName.get(fixture.getHomeTeam());
            String awayTeamName = teamIdToName.get(fixture.getAwayTeam());

            String formattedKickOff = "";
            if (fixture.getKickOffTime() != null) {
                ZonedDateTime utcTime = ZonedDateTime.parse(fixture.getKickOffTime());
                formattedKickOff = formatter.format(utcTime);
            }

            FixtureDTO dto = new FixtureDTO(homeTeamName, awayTeamName, formattedKickOff);
            fixtureDTOs.add(dto);
        }

        return fixtureDTOs;
    }

    public List<PlayerTransferDTO> getTopTransferredInPlayers() {
        FPLResponse data = fplAPIClient.fetchFplData();

        return data.getPlayers().stream()
                .sorted(Comparator.comparingInt(Player::getTransfersInEvent).reversed())
                .limit(5)
                .map(player -> new PlayerTransferDTO(
                        player.getFirstName() + " " + player.getSecondName(),
                        player.getNowCost() / 10.0,
                        player.getTotalPoints(),
                        player.getTransfersInEvent()
                ))
                .collect(Collectors.toList());
    }

    public List<PlayerTransferDTO> getTopTransferredOutPlayers() {
        FPLResponse data = fplAPIClient.fetchFplData();

        return data.getPlayers().stream()
                .sorted(Comparator.comparingInt(Player::getTransfersOutEvent).reversed())
                .limit(5)
                .map(player -> new PlayerTransferDTO(
                        player.getFirstName() + " " + player.getSecondName(),
                        player.getNowCost() / 10.0,
                        player.getTotalPoints(),
                        player.getTransfersOutEvent()
                ))
                .collect(Collectors.toList());
    }
}
