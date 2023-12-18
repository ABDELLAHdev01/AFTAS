package com.example.aftasapi.services;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;

import java.util.Optional;
import java.util.List;


public interface RankingService {

    public Ranking AddMemberToRanking(Ranking ranking);

    Optional<Ranking> findRankingByMember(Member member);

    List<Ranking> getAllRanksByCompetition(String code);

    List<Ranking> ShowfinalRankings(String code);

    void calculateRank( Member member , Fish fish);



}
