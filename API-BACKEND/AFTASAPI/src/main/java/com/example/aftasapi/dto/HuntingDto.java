package com.example.aftasapi.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HuntingDto {

    @NotBlank(message = "Competition code is required")
    private String code;
    private Long fishId;
    @NotNull(message = "Numbers is required")
    private Long number;
    @NotNull(message = "Weight is required")
    private Double weight;

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
