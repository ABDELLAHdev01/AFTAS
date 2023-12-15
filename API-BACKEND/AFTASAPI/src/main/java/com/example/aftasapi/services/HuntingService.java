package com.example.aftasapi.services;

import com.example.aftasapi.dto.HuntingDto;
import com.example.aftasapi.entities.Hunting;

import java.util.List;

public interface HuntingService {

    public Hunting addhunt(HuntingDto hunt);
    public List<Hunting> getAllHunts();

}
