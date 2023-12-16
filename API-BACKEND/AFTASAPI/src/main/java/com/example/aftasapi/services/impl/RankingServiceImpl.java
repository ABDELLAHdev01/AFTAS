package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.repositories.RankingRepository;
import com.example.aftasapi.services.RankingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;

    public RankingServiceImpl(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    @Override
    public Ranking AddMemberToRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    @Override
    public Optional<Ranking> findRankingByMember(Member member) {
        return rankingRepository.findByMember(member);
    }

    @Override
    public List<Ranking> getAllRanksByCompetition(String code) {
        return rankingRepository.findAllByCompetitionCode(code);
    }

    @Override
    public List<Ranking> getAllRanks() {
        return rankingRepository.findAll();
    }

    @Override
    public void calculateRank(Member member, Fish fish) {
        Ranking rank = findRankingByMember(member).get();
        rank.setScore(rank.getScore()+ fish.getLevel().getPoints());
        rankingRepository.save(rank);

    }
}
