package com.example.aftasapi.entities;

import com.example.aftasapi.entities.embadded.RankId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ranking implements Serializable {

    @EmbeddedId
    private RankId id;
    private Integer rank;
    private Integer score;
    @ManyToOne
    @MapsId("memberNumber")
    private Member member;
    @ManyToOne
    @MapsId("competitionCode")
    private Competition competition;
}
