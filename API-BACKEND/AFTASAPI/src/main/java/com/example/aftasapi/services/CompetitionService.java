package com.example.aftasapi.services;

import com.example.aftasapi.entities.Competition;

public interface CompetitionService {

    public Competition CreateCompetition(Competition competition) throws NoSuchFieldException;
}
