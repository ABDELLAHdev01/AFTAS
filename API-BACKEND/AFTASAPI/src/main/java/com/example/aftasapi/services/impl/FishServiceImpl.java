package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.repositories.FishRepository;
import com.example.aftasapi.services.FishService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;

    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }



    @Override
    public Optional<Fish> GetFish(Long id) {
        return fishRepository.findById(id);
    }

    @Override
    public Fish AddFish(Fish fish) {
        return fishRepository.save(fish);
    }
}
