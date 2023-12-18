package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Member;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @NotNull(message = "Date is required")
    @Future(message = "Date must be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "Start time is required")
    private LocalTime startTime;
    @NotNull(message = "End time is required")
    private LocalTime endTime;
    private Integer numberOfParticipants;
    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Amount is required")
    @PositiveOrZero
    private Double amount;



    public Competition mapToEntity(){
        return Competition.builder()
                .code(code)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .location(location)
                .amount(amount)
                .build();
    }

    public CompetitionDto EntityToMap(Competition competition){
        return CompetitionDto.builder()
                .code(competition.getCode())
                .date(competition.getDate())
                .startTime(competition.getStartTime())
                .endTime(competition.getEndTime())
                .numberOfParticipants(competition.getNumberOfParticipants())
                .amount(competition.getAmount())
                .location(competition.getLocation())
                .build();
    }
}
