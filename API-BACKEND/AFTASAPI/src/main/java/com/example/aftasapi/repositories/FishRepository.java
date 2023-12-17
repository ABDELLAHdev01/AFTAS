package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository  extends JpaRepository<Fish,Long> {
}
