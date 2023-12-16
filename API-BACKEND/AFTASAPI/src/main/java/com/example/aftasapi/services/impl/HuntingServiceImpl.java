package com.example.aftasapi.services.impl;

import com.example.aftasapi.dto.HuntingDto;
import com.example.aftasapi.entities.*;
import com.example.aftasapi.repositories.HuntingRepository;
import com.example.aftasapi.services.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;

    private final FishService fishService;
    private final MemberService memberService;


    private final CompetitionService compService;

    private final RankingService rankingService;

    public HuntingServiceImpl(HuntingRepository huntingRepository, FishService fishService, MemberService memberService, CompetitionService compService, RankingService rankingService) {
        this.huntingRepository = huntingRepository;
        this.fishService = fishService;
        this.memberService = memberService;
        this.compService = compService;
        this.rankingService = rankingService;
    }


    @Override
    public Hunting addhunt(HuntingDto hunt) {

        Optional<Member> member = memberService.getMemberbyID(hunt.getNumber());
        Optional<Ranking> Ranking = rankingService.findRankingByMember(member.get());

        ValidateMemberBeforeAddingHunting(member,Ranking);

        Optional<Competition> competition = compService.getCompetitionBycode(hunt.getCode());
        ValidateCompetitionBeforeAddinHunt(competition);


        Optional<Fish> fish = fishService.GetFish(hunt.getFishId());
        ValiateFishBeforeAddingHunting(fish,hunt.getWeight());


        Hunting hunting = Hunting.builder()
                .fish(fish.get())
                .competition(competition.get())
                .member(member.get())
                .numberOfFish(1)
                .build();

        Optional<Hunting> ExisteRec = huntingRepository.findHuntingByCompetitionAndMemberAndFish(competition.get(), member.get(), fish);

        if (ExisteRec.isPresent()) {

            ExisteRec.get().setNumberOfFish(ExisteRec.get().getNumberOfFish() + 1);
            rankingService.calculateRank(member.get(), fish.get());
            return huntingRepository.save(ExisteRec.get());


        } else {
            rankingService.calculateRank(member.get(), fish.get());
            return huntingRepository.save(hunting);

        }


    }

    @Override
    public List<Hunting> getAllHunts() {
        return huntingRepository.findAll();
    }

    public void ValidateMemberBeforeAddingHunting(Optional<Member> member, Optional<Ranking> ranking){
        if (member.isEmpty()) {
            throw new IllegalArgumentException("The member its not correct");

        }
        if (ranking.isEmpty()) {
            throw new IllegalArgumentException("The member its not registered to the compitiion");

        }

    }

    public void ValiateFishBeforeAddingHunting(Optional<Fish> fish ,Double size){
        if (fish.isEmpty()) {
            throw new IllegalArgumentException("The fish its not correct");

        }

        if (fish.get().getAverageWeight() > size) {
            throw new IllegalArgumentException("The weight of the fish is not avrage");

        }
    }

    private void ValidateCompetitionBeforeAddinHunt(Optional<Competition> competition) {
        if (competition.isEmpty()) {
            throw new IllegalArgumentException("The competition its not correct");

        }
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        if (!competition.get().getDate().isEqual(currentDate)) {
            throw new IllegalArgumentException("The competition starts at " + competition.get().getDate());

        }
        if (competition.get().getStartTime().isAfter(currentTime)) {
            throw new IllegalArgumentException("The competition its starting at " + competition.get().getStartTime());

        }
    }




}
