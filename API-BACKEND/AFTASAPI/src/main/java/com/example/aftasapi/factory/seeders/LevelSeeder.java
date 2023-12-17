package com.example.aftasapi.factory.seeders;

import com.example.aftasapi.entities.Level;
import com.example.aftasapi.repositories.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class LevelSeeder {
    private final LevelRepository levelRepository;
    public LevelSeeder(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
    private final Level[] levels = {
            Level.builder().code(1).points(50)
                    .description("Novice Angler: Embarking on the journey of fishing by targeting easy-to-find and smaller fishes.")
                    .build(),
            Level.builder().code(2).points(100)
                    .description("Intermediate Angler: Making substantial progress, aiming for a variety of medium-sized fishes.")
                    .build(),
            Level.builder().code(3).points(200)
                    .description("Proficient Angler: Demonstrating skills and proficiency, taking on larger and more challenging catches.")
                    .build(),
            Level.builder().code(4).points(400)
                    .description("Experienced Angler: Seasoned in the art of fishing, targeting specific species and exploring diverse techniques.")
                    .build(),
            Level.builder().code(5).points(800)
                    .description("Master Angler: Mastery achieved, pursuing the biggest and most elusive ocean dwellers.")
                    .build(),
            Level.builder().code(6).points(1500)
                    .description("Legendary Angler: Attained legendary status, sharing knowledge and skills with fellow fishing enthusiasts.")
                    .build(),
            Level.builder().code(7).points(2500)
                    .description("Elite Angler: Among the elite, hunting challenging species in deep waters.")
                    .build(),
            Level.builder().code(8).points(4000)
                    .description("Ocean Explorer: Unraveling the mysteries of the ocean, encountering rare and mystical sea creatures.")
                    .build(),
            Level.builder().code(9).points(6000)
                    .description("Ocean Conqueror: Conquering the vast expanse of the ocean, seeking out legendary and elusive marine species.")
                    .build(),
            Level.builder().code(10).points(7500)
                    .description("Titanic Hunter: A hunter of titanic proportions, pursuing the largest and most legendary oceanic trophies.")
                    .build()
    };


    public void seeding(){
      List<Level> emptylevels =   levelRepository.findAll();
      if (emptylevels.isEmpty()){
          levelRepository.saveAll(Arrays.stream(levels).toList());


    }}


}
