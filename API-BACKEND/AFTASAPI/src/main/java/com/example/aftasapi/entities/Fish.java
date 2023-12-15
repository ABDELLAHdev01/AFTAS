package com.example.aftasapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Hunting> huntingList;
    @ManyToOne
    @JsonBackReference
    private Level level;
}
