package com.example.aftasapi.entities.embadded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class RankId implements Serializable {

    Long memberNumber;
    String competitionCode;
}