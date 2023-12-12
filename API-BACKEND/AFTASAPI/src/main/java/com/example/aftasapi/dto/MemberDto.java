package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {

    private Long id;
    @NotBlank(message="Name is required")
    @Size(max=20,message="Name must be at most 20 characters")
    private String name;

    @NotBlank(message="familyName is required")
    @Size(max=20,message="Name must be at most 20 characters")
    private String familyName;

    @JsonProperty("accession_date")
    @NotBlank(message="accessionDate is required")
    private Date accessionDate;

    @NotBlank(message="nationality is required")
    private String nationality;

    @NotBlank(message="IdentityDocumentType is required")
    private IdentityDocumentType identityDocumentType;

    @NotBlank(message="identityNumber is required")
    private String identityNumber;

    private List<Ranking> rankings;
    private List<Hunting> huntings;

    public Member mapToEntity(){
        return Member.builder()
                .name(name)
                .familyName(familyName)
                .accessionDate(accessionDate)
                .nationality(nationality)
                .identityDocumentType(IdentityDocumentType.valueOf(identityDocumentType.name()))
                .identityNumber(identityNumber)
                .rankings(rankings)
                .huntings(huntings)
                .build();
    }
}
