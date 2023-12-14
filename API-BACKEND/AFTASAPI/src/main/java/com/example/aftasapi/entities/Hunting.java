package com.example.aftasapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "huntings")
public class Hunting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfFish;
    @ManyToOne
    private Fish fish;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Competition competition;

}
