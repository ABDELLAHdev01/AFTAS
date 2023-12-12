package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Ranking;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetitionDto {

    private Long id;

    private Date date;

    private Time startTime;

    private Time endTime;

    private Integer numberOfParticipant;

    private String location;

    private Double amount;

    private List<Hunting> hunting;

    private List<Ranking> ranks;


    public Competition mapToEntity(){
        return Competition.builder()
                .id(this.id)
                .date(this.date)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .numberOfParticipant(this.numberOfParticipant)
                .amount(this.amount)
                .location(this.location)
                .hunting(this.hunting)
                .ranks(this.ranks)
                .build();
    }

}
