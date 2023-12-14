package com.example.aftasapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    private String description;
    private Integer points;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Fish> fishList;
}


