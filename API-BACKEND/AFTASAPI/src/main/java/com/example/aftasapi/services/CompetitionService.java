package com.example.aftasapi.services;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Ranking;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {

    public Competition CreateCompetition(Competition competition) throws NoSuchFieldException;
    public List<Competition> getCompetitionList();

    public Optional<Competition> getCompetitionBycode(String code);
    public Ranking AssingMemberToCompetition(Long memberId, String codeComp);
}
