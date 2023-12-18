package com.example.aftasapi.dto;

import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Level;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class fishDto {

    private Long id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "averageWeight is required")
    private Double averageWeight;
    private Integer level_id;

    public Fish DtoToEntity(){
        return Fish.builder()
                .id(id)
                .name(name)
                .averageWeight(averageWeight)
                .build();
    }
}
