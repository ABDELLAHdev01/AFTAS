package com.example.aftasapi.services.impl;

import com.example.aftasapi.dto.HuntingDto;
import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.repositories.HuntingRepository;
import com.example.aftasapi.services.CompetitionService;
import com.example.aftasapi.services.FishService;
import com.example.aftasapi.services.HuntingService;
import com.example.aftasapi.services.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;

    private final FishService fishService;
    private final MemberService memberService;


    private final CompetitionService compService;
    public HuntingServiceImpl(HuntingRepository huntingRepository, FishService fishService, MemberService memberService, CompetitionService compService) {
        this.huntingRepository = huntingRepository;
        this.fishService = fishService;
        this.memberService = memberService;
        this.compService = compService;
    }


    @Override
    public Hunting addhunt(HuntingDto hunt) {
        Optional<Member> member = memberService.getMemberbyID(hunt.getNumber());
        Optional<Competition> competition = compService.getCompetitionBycode(hunt.getCode());
        Optional<Fish> fish = fishService.GetFish(hunt.getFishId());
       Hunting hunting = Hunting.builder()
                .fish(fish.get())
                .competition(competition.get())
                .member(member.get())
                .numberOfFish(0)
                .build();

        return huntingRepository.save(hunting);

    }

    @Override
    public List<Hunting> getAllHunts() {
        return huntingRepository.findAll();
    }
}
