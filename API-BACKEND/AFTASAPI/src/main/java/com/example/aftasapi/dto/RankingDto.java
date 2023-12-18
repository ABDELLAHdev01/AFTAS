package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter

public class RankingDto {
    private Long memberId;
    private String codeCompetition;
}
