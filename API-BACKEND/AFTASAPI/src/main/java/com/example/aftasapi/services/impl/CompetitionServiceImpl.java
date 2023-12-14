package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.repositories.CompetitionRepository;
import com.example.aftasapi.services.CompetitionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    public final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getCompetitionList() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition CreateCompetition(Competition competition)  {

        return competitionRepository.save(competition);
            }
}
