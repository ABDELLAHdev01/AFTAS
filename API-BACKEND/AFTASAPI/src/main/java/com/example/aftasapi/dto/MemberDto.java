package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private String familyName;
    @JsonProperty("accession_date")
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    private List<Ranking> rankings;
    private List<Hunting> huntings;
}
