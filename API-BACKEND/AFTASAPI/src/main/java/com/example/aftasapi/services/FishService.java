package com.example.aftasapi.services;

import com.example.aftasapi.entities.Fish;

import java.util.Optional;

public interface FishService {

    Optional<Fish> GetFish(Long id);

    Fish AddFish(Fish fish);
}
