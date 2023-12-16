package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.RankingDto;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.services.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }


    @GetMapping("/rankbycomp")
    public  ResponseEntity<Map<String,Object>> getMembers(@RequestBody String Code){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Ranking> allRanksByCompetition = rankingService.getAllRanks();
            response.put("success", allRanksByCompetition);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
