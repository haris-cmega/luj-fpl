package com.example.luj_fpl.controller;

import com.example.luj_fpl.dto.FixtureDTO;
import com.example.luj_fpl.dto.PlayerTransferDTO;
import com.example.luj_fpl.service.FPLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FplController {
    private FPLService fplService;

    public FplController(FPLService fplService){
        this.fplService = fplService;
    }

    @GetMapping("/deadline")
    public String getGameweekDeadline(){
        return fplService.getGameweekDeadline();
    }

    @GetMapping("/fixtures")
    public List<FixtureDTO> getGameweekFixtures(){
        return fplService.getNextGameweekFixtures();
    }

    @GetMapping("/mostTransferredIn")
    public List<PlayerTransferDTO> getMostTransferredIn(){
        return fplService.getTopTransferredInPlayers();
    }

    @GetMapping("/mostTransferredOut")
    public List<PlayerTransferDTO> getMostTransferredOut(){
        return fplService.getTopTransferredOutPlayers();
    }

}
