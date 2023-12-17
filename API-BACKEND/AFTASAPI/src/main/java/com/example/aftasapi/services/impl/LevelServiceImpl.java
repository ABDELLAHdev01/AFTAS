package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Level;
import com.example.aftasapi.repositories.LevelRepository;
import com.example.aftasapi.services.LevelService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Optional<Level> getlevel(long id) {
        return levelRepository.findById(id);
    }
}
