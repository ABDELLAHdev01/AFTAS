package com.example.aftasapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "huntings")
public class Hunting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfFish;
    @ManyToOne
    @JsonBackReference
    private Fish fish;
    @ManyToOne
    @JsonBackReference
    private Member member;
    @ManyToOne
    @JsonBackReference
    private Competition competition;

}
