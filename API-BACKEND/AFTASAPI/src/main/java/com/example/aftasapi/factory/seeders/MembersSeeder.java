package com.example.aftasapi.factory.seeders;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.enums.IdentityDocumentType;
import com.example.aftasapi.repositories.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@Component
public class MembersSeeder {

    private final MemberRepository memberRepository;

    public MembersSeeder(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final Member[] members = {
            Member.builder()
                    .firstName("John").lastName("frieddie").nationality("Morocco").accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.PASSPORT).identityNumber("dd23456789")
                    .build(),
            Member.builder()
                    .firstName("Alice").lastName("Johnson").nationality("USA")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.NATIONAL_ID).identityNumber("us12345678")
                    .build(),

            Member.builder()
                    .firstName("David").lastName("Smith").nationality("Canada")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.DRIVER_LICENSE).identityNumber("ca98765432")
                    .build(), Member.builder()
            .firstName("Sophia").lastName("Lee").nationality("South Korea")
            .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.PASSPORT).identityNumber("sk87654321")
            .build(),

            Member.builder()
                    .firstName("Mohammed").lastName("Al-Farsi").nationality("United Arab Emirates")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.NATIONAL_ID).identityNumber("ae34567890")
                    .build(),

            Member.builder()
                    .firstName("Isabella").lastName("Martinez").nationality("Mexico")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.DRIVER_LICENSE).identityNumber("mx65432109")
                    .build(),

            Member.builder()
                    .firstName("Oliver").lastName("Brown").nationality("Australia")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.PASSPORT).identityNumber("au23456789")
                    .build(),

            Member.builder()
                    .firstName("Emma").lastName("Kim").nationality("Japan")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.NATIONAL_ID).identityNumber("jp98765432")
                    .build(),

            Member.builder()
                    .firstName("Daniel").lastName("Chen").nationality("China")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.DRIVER_LICENSE).identityNumber("cn87654321")
                    .build(),

            Member.builder()
                    .firstName("Ava").lastName("Garcia").nationality("Spain")
                    .accessionDate(LocalDate.now()).identityDocument(IdentityDocumentType.PASSPORT).identityNumber("es34567890")
                    .build()

    };


    public void seeding(){
        List<Member> emptymembers = memberRepository.findAll();
        if (emptymembers.isEmpty()){
            memberRepository.saveAll(Arrays.stream(members).toList());
        }
    }

}
