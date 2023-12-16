package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.fishDto;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.services.FishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fish")
public class FishController {

    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> getallFishes() {
        Map<String, Object> response = new HashMap<>();

        try {
            List<Fish> allFishes = fishService.GetAllFish();
            response.put("success", allFishes);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody fishDto fish) {
        Map<String, Object> response = new HashMap<>();

        try {
            fishService.AddFish(fish.DtoToEntity());
            response.put("fish", fish);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

}
