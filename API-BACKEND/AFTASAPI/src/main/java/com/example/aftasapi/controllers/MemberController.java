package com.example.aftasapi.controllers;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.services.MemberService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/addmember")
    public ResponseEntity<Map<String, Object>>addMember(@RequestBody Member member) {
        Map<String, Object> response = new HashMap<>();

        try {


            response.put("message", "User created successfully");
            response.put("member",memberService.addMember(member));
            return ResponseEntity.ok(response);

        }catch (Exception e) {
            response.put("status", "error");
            response.put("message", "member already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        }
    }

}
