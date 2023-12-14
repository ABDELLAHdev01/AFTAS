package com.example.aftasapi.services;

import com.example.aftasapi.entities.Competition;

import java.util.List;

public interface CompetitionService {

    public Competition CreateCompetition(Competition competition) throws NoSuchFieldException;
    public List<Competition> getCompetitionList();
}
