package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Fish;
import com.example.aftasapi.entities.Hunting;
import com.example.aftasapi.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting,Long> {



    Optional<Hunting> findHuntingByCompetitionAndMemberAndFish(Competition competition, Member member, Optional<Fish> fish);
}
