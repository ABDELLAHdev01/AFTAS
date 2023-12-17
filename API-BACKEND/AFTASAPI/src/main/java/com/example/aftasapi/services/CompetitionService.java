package com.example.aftasapi.services;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Ranking;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {

    public Competition CreateCompetition(Competition competition) throws NoSuchFieldException;
    public List<Competition> getCompetitionList();
    public List<Competition> getCompetitionListByField(String field);

    public Page<Competition> getCompetitionListWithPagination(int offset, int pageSize);

    public Optional<Competition> getCompetitionBycode(String code);
    public Ranking AssingMemberToCompetition(Long memberId, String codeComp);


}
