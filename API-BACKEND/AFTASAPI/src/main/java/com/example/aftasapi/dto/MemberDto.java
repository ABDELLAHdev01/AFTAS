package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.enums.IdentityDocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;



import java.time.LocalDate;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @NotBlank(message = "First name is required")
    private String firstName;
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @NotBlank(message = "Last name is required")
    @Pattern(regexp="[^0-9]*$",message = "Last name must only contain characters")
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accessionDate;
    @NotBlank(message = "Nationality is required")
    @Size(min = 2, max = 50, message = "Nationality must be between 2 and 50 characters")
    private String nationality;
    private IdentityDocumentType identityDocument;
    @NotBlank(message = "Identity number is required")
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
