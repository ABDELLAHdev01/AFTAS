package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.enums.IdentityDocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String firstName;
    private String lastName;
    private LocalDate accessionDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocument;
    private String identityNumber;


    public MemberDto MemberToDto(Member member) {
        return MemberDto.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .accessionDate(member.getAccessionDate())
                .nationality(member.getNationality())
                .identityDocument(member.getIdentityDocument())
                .identityNumber(member.getIdentityNumber())
                .build();
    }

    public Member DtoToMember() {
        return Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .accessionDate(accessionDate)
                .nationality(nationality)
                .identityNumber(identityNumber)
                .identityDocument(identityDocument)
                .build();
    }


}
