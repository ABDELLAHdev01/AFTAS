package com.example.aftasapi.entities;

import com.example.aftasapi.entities.embadded.RankId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "score")
    private Integer score;
    @ManyToOne
    @MapsId("memberNumber")
    @JsonBackReference
    private Member member;
    @ManyToOne
    @MapsId("competitionCode")
    @JsonBackReference
    private Competition competition;
}
