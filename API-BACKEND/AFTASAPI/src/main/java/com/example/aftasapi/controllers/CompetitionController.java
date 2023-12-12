package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.CompetitionDto;
import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.services.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }


    @PostMapping("/addComp")
    public ResponseEntity<Map<String, Object>> addComp(@RequestBody CompetitionDto competitionDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            Competition competition = competitionService.CreateCompetition(competitionDto.mapToEntity());

            response.put("success", true);
            response.put("competition", competition);

            return ResponseEntity.ok(response);


        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());

            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

}
