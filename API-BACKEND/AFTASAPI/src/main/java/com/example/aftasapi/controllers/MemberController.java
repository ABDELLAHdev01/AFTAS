package com.example.aftasapi.controllers;

import com.example.aftasapi.dto.MemberDto;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> addMember(@Valid @RequestBody MemberDto member) {
        Map<String, Object> response = new HashMap<>();

        try {

            Member newMember = memberService.addMember(member.DtoToMember());
            response.put("message", "User created successfully");
            response.put("member", newMember);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "member already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        }
    }

    @GetMapping
    public  ResponseEntity<Map<String,Object>> getMembers(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Member> allMembers = memberService.GetAllMembers();
            response.put("members", allMembers);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

}
