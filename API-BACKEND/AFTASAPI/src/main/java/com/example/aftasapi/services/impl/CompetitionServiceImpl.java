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

        if(competition.getEndTime().before(competition.getStartTime())) {
            throw new IllegalArgumentException("Date of the event's end time before the event's start time");
        }

        LocalDate newDate = competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<Competition> competitionList = getCompetitionList();

        for (Competition competition1 : competitionList) {
            LocalDate existingDate = competition1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (existingDate.equals(newDate)) {
                throw new IllegalArgumentException("theres a competition in the same day");

            }
        }

        if (competition.getDate().before(new Date())) { // checkiw wach f past
            return null;
        } else {
            // checking if it after 6 months
            LocalDate date = LocalDate.now().plusMonths(12);
            Date dd = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            // dd hya date now + 9months
            if (competition.getDate().after(dd)) { // cheking wach mora 9 months
                throw new IllegalArgumentException("You Cannot add a competition at more than year");
            } else {
                return competitionRepository.save(competition);
            }
        }


    }
}
