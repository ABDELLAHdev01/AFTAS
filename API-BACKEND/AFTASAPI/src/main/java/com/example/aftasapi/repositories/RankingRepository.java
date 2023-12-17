package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {

    Optional<Ranking> findByMember(Member member);

    List<Ranking> findAllByCompetitionCode(String competition_code);

}
