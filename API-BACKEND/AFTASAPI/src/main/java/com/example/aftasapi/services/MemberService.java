package com.example.aftasapi.services;

import com.example.aftasapi.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public Member addMember(Member member);

    public Member removeMember(Member member);

    public Optional<Member> getMemberbyID(Long id);

    public List<Member> GetAllMembers();
}
