package com.example.aftasapi.factory;

import com.example.aftasapi.factory.seeders.FishSeeder;
import com.example.aftasapi.factory.seeders.LevelSeeder;
import com.example.aftasapi.factory.seeders.MembersSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppSeed {

    private final LevelSeeder levelSeeder;
    private final FishSeeder fishSeeder;
    private final MembersSeeder membersSeeder;

    public AppSeed(LevelSeeder levelSeeder, FishSeeder fishSeeder, MembersSeeder membersSeeder) {
        this.levelSeeder = levelSeeder;
        this.fishSeeder = fishSeeder;
        this.membersSeeder = membersSeeder;
    }

    @PostConstruct
    public void init() {
        levelSeeder.seeding();
        fishSeeder.seeding();
        membersSeeder.seeding();
    }

}
