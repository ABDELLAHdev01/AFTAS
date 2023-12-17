package com.example.aftasapi.factory.seeders;

import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Level;
import com.example.aftasapi.repositories.FishRepository;
import com.example.aftasapi.repositories.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@Component
public class FishSeeder {

    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;


    public FishSeeder(FishRepository fishRepository, LevelRepository levelRepository) {
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
    }

    private final Fish[] fishes = {
            Fish.builder().name("Bluefin Tuna").averageWeight(5.0).level(Level.builder().code(9).build()).build(),
            Fish.builder().name("Atlantic Salmon").averageWeight(2.0).level(Level.builder().code(2).build()).build(),
            Fish.builder().name("Diamond Flounder").averageWeight(0.7).level(Level.builder().code(1).build()).build(),
            Fish.builder().name("Golden Perch").averageWeight(0.8).level(Level.builder().code(1).build()).build(),
            Fish.builder().name("River Carp").averageWeight(3.0).level(Level.builder().code(3).build()).build(),
            Fish.builder().name("Pacific Cod").averageWeight(2.0).level(Level.builder().code(2).build()).build(),
            Fish.builder().name("Atlantic Haddock").averageWeight(1.5).level(Level.builder().code(2).build()).build(),
            Fish.builder().name("Red Snapper").averageWeight(2.0).level(Level.builder().code(2).build()).build(),
            Fish.builder().name("Mango Snapper").averageWeight(2.5).level(Level.builder().code(2).build()).build(),
            Fish.builder().name("Bronze Bass").averageWeight(3.0).level(Level.builder().code(3).build()).build(),
            Fish.builder().name("Rainbow Trout").averageWeight(1.0).level(Level.builder().code(1).build()).build(),
            Fish.builder().name("Sapphire Grouper").averageWeight(4.0).level(Level.builder().code(5).build()).build(),
    };


    public void seeding() {
        List<Fish> emptylist = fishRepository.findAll();
        if(emptylist.isEmpty())
            Arrays.stream(fishes).forEach(fish -> {
                Optional<Level> optionalLevel = levelRepository.getLevelByCode(fish.getLevel().getCode());
                if(optionalLevel.isPresent()){
                    fish.setLevel(optionalLevel.get());
                    fishRepository.save(fish);
                }
            });
    }


}
