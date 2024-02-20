package com.example.aftasapi.repositories;

import com.example.aftasapi.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository  extends JpaRepository<Member,Long> {
    @Query(value = "SELECT * FROM member u WHERE u.email = :email", nativeQuery = true)
    Optional<Member> findByEmailNativeQuery( String email);
}
