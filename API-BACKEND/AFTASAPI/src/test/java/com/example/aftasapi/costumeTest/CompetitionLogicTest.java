package com.example.aftasapi.costumeTest;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.services.CompetitionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CompetitionLogicTest {

    @Autowired
    public CompetitionService competitionService;


    @Test
    public void test_createCompetition_validInput() {
        // Arrange
        Competition competition = new Competition();
        competition.setDate(Date.from(new Date().toInstant()));



        // Act
        Competition result = competitionService.CreateCompetition(competition);

        // Assert
       assertNotNull(result);
    }


}
