package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.HuntingDto;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.services.HuntingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Map<String, Object>> addHunt(@RequestBody HuntingDto hunting) {
        Map<String, Object> response = new HashMap<>();

        try {
            Hunting newhunt = huntingService.addhunt(hunting);

            response.put("hunt", newhunt);
            return ResponseEntity.ok(response);
        } catch (Exception e) {

            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllHunts() {
        Map<String, Object> response = new HashMap<>();

        try {
            List<Hunting> allhunts = huntingService.getAllHunts();


            response.put("all", allhunts);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        }
    }
}
