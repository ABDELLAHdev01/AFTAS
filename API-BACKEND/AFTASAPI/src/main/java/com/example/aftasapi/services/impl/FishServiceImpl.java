package com.example.aftasapi.services.impl;

import com.example.aftasapi.dto.fishDto;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Level;
import com.example.aftasapi.repositories.FishRepository;
import com.example.aftasapi.services.FishService;
import com.example.aftasapi.services.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;
    private final LevelService levelService;

    public FishServiceImpl(FishRepository fishRepository, LevelService levelService) {
        this.fishRepository = fishRepository;
        this.levelService = levelService;
    }



    @Override
    public Optional<Fish> GetFish(Long id) {
        return fishRepository.findById(id);
    }



    @Override
    public Fish AddFish(fishDto fish) {
       Level level =  levelService.getlevel(fish.getLevel_id()).get();

       Fish fish1 = fish.DtoToEntity();
       fish1.setLevel(level);

        return fishRepository.save(fish1);
    }

    @Override
    public List<Fish> GetAllFish() {
        return fishRepository.findAll();
    }
}
