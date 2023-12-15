package com.example.aftasapi.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HuntingDto {

    private String code;
    private Long fishId;
    private Long number;

    private Integer rank;
    private Integer score;


//    public Hunting MapToEntity(){
//        return  Hunting.builder()
//                .member(Member.builder().number(number).build())
//                .competition(Competition.builder().code(code).build())
//                .fish(Fish.builder().id(FishId).build())
//        .build();
//
//    }

}
