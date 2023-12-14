package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private RankId id;
    private Integer rank;
    private Integer score;

    private Member member;

    private Competition competition;

    public RankingDto EntityToDto(Ranking ranking){
        return RankingDto.builder()
                .rank(ranking.getRank())
                .id(ranking.getId())
                .score(ranking.getScore())
                .competition(ranking.getCompetition())
                .member(ranking.getMember())
                .build();
    }

    public Ranking MapToEntity(){
        return Ranking.builder()
                .id(id)
                .rank(rank)
                .score(score)
                .member(member)
                .competition(competition)
                .build();
    }
}
