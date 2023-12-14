package com.example.aftasapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "fishes")
public class Fish {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double averageWeight;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fish")
    private List<Hunting> huntingList;
    @ManyToOne
    private Level level;
}
