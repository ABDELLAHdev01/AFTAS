package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository  extends JpaRepository<Fish,Long> {
}
