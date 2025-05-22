package com.example.luj_fpl.controller;

import com.example.luj_fpl.service.FPLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FplController {
    private FPLService fplService;

    public FplController(FPLService fplService){
        this.fplService = fplService;
    }

    @GetMapping("/deadline")
    public String getGameweekDeadline(){
        return fplService.getGameweekDeadline();
    }
}
