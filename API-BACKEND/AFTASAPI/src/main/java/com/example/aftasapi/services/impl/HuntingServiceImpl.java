package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.repositories.HuntingRepository;
import com.example.aftasapi.services.HuntingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;

    public HuntingServiceImpl(HuntingRepository huntingRepository) {
        this.huntingRepository = huntingRepository;
    }


    @Override
    public Hunting addhunt(Hunting hunt) {
        return huntingRepository.save(hunt);
    }

    @Override
    public List<Hunting> getAllHunts() {
        return huntingRepository.findAll();
    }
}
