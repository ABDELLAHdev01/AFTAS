package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.RankingDto;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.services.RankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> AddRanking(@RequestBody RankingDto newRanking){
        Map<String, Object> response = new HashMap<>();
           Ranking newRank =  rankingService.AddMemberToRanking(newRanking.MapToEntity());
           newRanking.EntityToDto(newRank);
           response.put("success",newRanking);

           return ResponseEntity.ok(response);


    }
}
