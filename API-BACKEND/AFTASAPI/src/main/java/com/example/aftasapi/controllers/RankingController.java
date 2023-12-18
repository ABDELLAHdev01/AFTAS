package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.RankingDto;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.services.RankingService;
import jakarta.validation.Valid;
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


//    @GetMapping("/calculte/{code}")
//    public  ResponseEntity<Map<String,Object>> calculate(@PathVariable String code){
//        Map<String, Object> response = new HashMap<>();
//        try {
//            List<Ranking> calculated = rankingService.listScore(code);
//            response.put("success",calculated);
//            return ResponseEntity.ok(response);
//
//        }catch (Exception e){
//            response.put("error", e.getMessage());
//            return ResponseEntity.badRequest().body(response);
//        }
//    }

    @GetMapping("/finalrank/{co}")
    public  ResponseEntity<Map<String,Object>> finl( @PathVariable String co){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Ranking> allRanksByCompetition = rankingService.ShowfinalRankings(co);
            response.put("success", allRanksByCompetition);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @GetMapping("/rankbycomp/{co}")
    public  ResponseEntity<Map<String,Object>> getMembers(@PathVariable String co){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Ranking> allRanksByCompetition = rankingService.getAllRanksByCompetition(co);
            response.put("success", allRanksByCompetition);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
