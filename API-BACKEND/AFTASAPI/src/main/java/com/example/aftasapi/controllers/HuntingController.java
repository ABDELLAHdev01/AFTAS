package com.example.aftasapi.controllers;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.services.HuntingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hunting")
public class HuntingController {
    private final HuntingService huntingService;

    public HuntingController(HuntingService huntingService) {
        this.huntingService = huntingService;
    }


    @PostMapping("add")
    public ResponseEntity<Map<String,Object>> addHunt(Hunting hunting){
        Map<String, Object> response = new HashMap<>();
        Hunting newhunt = huntingService.addhunt(hunting);

        response.put("hunt", newhunt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> getAllHunts() {
        Map<String, Object> response = new HashMap<>();

        List<Hunting> allhunts = huntingService.getAllHunts();


        response.put("all", allhunts);
        return ResponseEntity.ok(response);
    }
    }
