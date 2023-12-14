package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.repositories.RankingRepository;
import com.example.aftasapi.services.RankingService;
import org.springframework.stereotype.Service;

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
}
