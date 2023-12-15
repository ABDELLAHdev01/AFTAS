package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.CompetitionDto;
import com.example.aftasapi.dto.RankingDto;
import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.services.CompetitionService;
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
    public ResponseEntity<Map<String, Object>> createCompetition(@RequestBody CompetitionDto competition) {
        Map<String, Object> response = new HashMap<>();
        try {


            Competition comp = competitionService.CreateCompetition(competition.mapToEntity());
            response.put("success", competition.EntityToMap(comp));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllComp() {
        Map<String, Object> response = new HashMap<>();
        try {


            List<Competition> allcomp = competitionService.getCompetitionList();
            response.put("AllCompetitions", allcomp);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("err", e);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/assing")
    public ResponseEntity<Map<String,Object>> AddRanking(@RequestBody RankingDto newRanking){
        Map<String, Object> response = new HashMap<>();


    competitionService.AssingMemberToCompetition( newRanking.getMemberId() , newRanking.getCodeCompetition());

            response.put("success", newRanking);
    return ResponseEntity.ok().body(response);

    }

}
