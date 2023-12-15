package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Member;
import com.example.aftasapi.repositories.MemberRepository;
import com.example.aftasapi.services.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Member> getMemberbyID(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> GetAllMembers() {
        return memberRepository.findAll();
    }
}
