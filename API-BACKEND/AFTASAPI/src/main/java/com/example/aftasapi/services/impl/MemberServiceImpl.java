package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.repositories.MemberRepository;
import com.example.aftasapi.services.MemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) {


        return memberRepository.save(member);

    }

    public Member removeMember(Member member) {
        return null;
    }

    public Member getMemberbyID(Long id) {
        return null;
    }
}
