package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.repositories.CompetitionRepository;
import com.example.aftasapi.services.CompetitionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public Competition CreateCompetition(Competition competition) {
        validateTime(competition);
        checkExistingCompetitions(competition);
        generateCompetitionCode(competition);


        return competitionRepository.save(competition);
    }

    private void generateCompetitionCode(Competition competition) {
        competition.setCode(competition.getDate() + "-" + competition.getLocation());
    }

    private void checkExistingCompetitions(Competition competition) {
        List<Competition> allComps = getCompetitionList();
        if (allComps.stream().anyMatch(comp -> comp.getDate() != null && comp.getDate().equals(competition.getDate()))) {
            throw new IllegalArgumentException("There's a Competition on the same day");
        }
    }

    private void validateTime(Competition competition) {
        LocalDate currentDate = LocalDate.now();

        if (competition.getDate().isBefore(currentDate)) {
            throw new IllegalArgumentException("You cannot create a competition in the past");

        }
        if (competition.getEndTime().isBefore(competition.getStartTime())) {
            throw new IllegalArgumentException("End Time cannot be before start");
        }

        if (!competition.getStartTime().plusHours(3).isBefore(competition.getEndTime())) {
            throw new IllegalArgumentException("Competition at least must be 3 hours");

        }
    }


}
