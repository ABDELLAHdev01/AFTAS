package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository  extends JpaRepository<Level,Long> {

    Optional<Level> getLevelByCode(Integer code);


}
