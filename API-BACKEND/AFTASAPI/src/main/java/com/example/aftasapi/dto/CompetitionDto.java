package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Member;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto {
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private Double amount;

    private List<Hunting> huntingList;

    public Competition mapToEntity(){
        return Competition.builder()
                .code(code)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .location(location)
                .amount(amount)
                .huntingList(huntingList)
                .build();
    }
}
