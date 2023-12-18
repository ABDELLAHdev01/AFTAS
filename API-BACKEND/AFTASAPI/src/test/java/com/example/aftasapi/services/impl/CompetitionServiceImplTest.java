package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.repositories.CompetitionRepository;
import com.example.aftasapi.services.CompetitionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionServiceImplTest {

    private final CompetitionService service;



    CompetitionServiceImplTest(CompetitionService service) {
        this.service = service;
    }

    @Test
    public void test_createCompetition_setsNumberOfParticipants() throws NoSuchFieldException {
        // Arrange
        Competition competition = new Competition();
        competition.setDate(LocalDate.now().plusDays(1));
        competition.setStartTime(LocalTime.of(9, 0));
        competition.setEndTime(LocalTime.of(12, 0));
        competition.setLocation("Location");
        competition.setAmount(100.0);



        // Act
        Competition createdCompetition = service.CreateCompetition(competition);

        // Assert
        assertNotNull(createdCompetition);
        assertEquals(0, createdCompetition.getNumberOfParticipants());
    }

    @Test
    void  test_createCompetition_dateInPast() {
        // Arrange
        Competition competition = new Competition();
        competition.setDate(LocalDate.now().minusDays(1));
        competition.setStartTime(LocalTime.of(9, 0));
        competition.setEndTime(LocalTime.of(12, 0));
        competition.setLocation("Location");
        competition.setAmount(100.0);

        assertThrows(IllegalArgumentException.class, () -> {
            service.CreateCompetition(competition);
        });
    }


    @Test
    public void test_createCompetition_endTimeBeforeStartTime() {
        // Arrange
        Competition competition = new Competition();
        competition.setDate(LocalDate.now().plusDays(1));
        competition.setStartTime(LocalTime.of(12, 0));
        competition.setEndTime(LocalTime.of(9, 0));
        competition.setLocation("Location");
        competition.setAmount(100.0);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.CreateCompetition(competition);
        });
    }


    @Test
    public void test_createCompetition_lessThanThreeHours() {
        // Arrange
        Competition competition = new Competition();
        competition.setDate(LocalDate.now().plusDays(1));
        competition.setStartTime(LocalTime.of(9, 0));
        competition.setEndTime(LocalTime.of(10, 0));
        competition.setLocation("Location");
        competition.setAmount(100.0);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.CreateCompetition(competition);
        });
    }

}