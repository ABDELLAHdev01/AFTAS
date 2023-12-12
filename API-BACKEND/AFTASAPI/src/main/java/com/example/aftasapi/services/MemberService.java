package com.example.aftasapi.services;

import com.example.aftasapi.entities.Member;

public interface MemberService {

    public Member addMember(Member member);

    public Member removeMember(Member member);

    public Member getMemberbyID(Long id);
}
