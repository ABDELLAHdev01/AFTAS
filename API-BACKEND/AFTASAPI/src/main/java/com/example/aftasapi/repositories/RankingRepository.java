package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, RankId> {

    Optional<Ranking> findByMember(Member member);

    List<Ranking> findAllByCompetitionCode(String competition_code);

}
