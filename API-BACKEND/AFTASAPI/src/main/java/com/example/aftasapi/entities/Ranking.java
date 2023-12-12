package com.example.aftasapi.entities;

import com.example.aftasapi.entities.embadded.MemberCompetition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @EmbeddedId
    private MemberCompetition id;

    private Integer rank;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    private Competition competition;
}
