package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, RankId> {

}
