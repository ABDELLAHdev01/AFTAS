package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.CompetitionDto;
import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.services.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    public Competition createCompetition(@RequestBody CompetitionDto competition) throws NoSuchFieldException {
        return competitionService.CreateCompetition(competition.mapToEntity());

    }
    @GetMapping("/all")
    public ResponseEntity<Map<String,List<Competition>>> getAllComp(){
        Map<String, List<Competition>> response = new HashMap<>();

        List<Competition> allcomp = competitionService.getCompetitionList();
        response.put("allcomp", allcomp);

        return ResponseEntity.ok(response);

    }

}
