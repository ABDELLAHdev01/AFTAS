package com.example.aftasapi.services;

import com.example.aftasapi.entities.Level;

import java.util.Optional;

public interface LevelService {

    Optional<Level> getlevel(long id);
}
