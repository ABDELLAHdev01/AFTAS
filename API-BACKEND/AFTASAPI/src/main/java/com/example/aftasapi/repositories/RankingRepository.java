package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {

    Optional<Ranking> findByMember(Member member);

    @Query("SELECT r FROM Ranking r WHERE r.competition.code = ?1 ORDER BY r.score DESC")
    List<Ranking> findByCompetitionCode(String competitionCode);

    List<Ranking> findRankingsByCompetitionOrderByScore(Competition competition);
}
