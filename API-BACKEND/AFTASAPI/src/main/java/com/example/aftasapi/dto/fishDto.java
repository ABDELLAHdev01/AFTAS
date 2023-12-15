package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Fish;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class fishDto {

    private Long id;
    private String name;
    private Double averageWeight;

    public Fish DtoToEntity(){
        return Fish.builder()
                .id(id)
                .name(name)
                .averageWeight(averageWeight)
                .build();
    }
}
