package com.example.aftasapi.factory;

import com.example.aftasapi.factory.seeders.FishSeeder;
import com.example.aftasapi.factory.seeders.LevelSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppSeed {

    private final LevelSeeder levelSeeder;
    private final FishSeeder fishSeeder;

    public AppSeed(LevelSeeder levelSeeder, FishSeeder fishSeeder) {
        this.levelSeeder = levelSeeder;
        this.fishSeeder = fishSeeder;
    }

    @PostConstruct
    public void init() {
        levelSeeder.seeding();
        fishSeeder.seeding();
    }

}
