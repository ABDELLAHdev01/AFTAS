package com.example.aftasapi.services.impl;

import com.example.aftasapi.entities.Competition;
import com.example.aftasapi.entities.Member;
import com.example.aftasapi.entities.Ranking;
import com.example.aftasapi.entities.embadded.RankId;
import com.example.aftasapi.repositories.CompetitionRepository;
import com.example.aftasapi.services.CompetitionService;
import com.example.aftasapi.services.MemberService;
import com.example.aftasapi.services.RankingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    public final CompetitionRepository competitionRepository;

    public final MemberService memberService;

    public final RankingService rankingService;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, MemberService memberService, RankingService rankingService) {
        this.competitionRepository = competitionRepository;
        this.memberService = memberService;
        this.rankingService = rankingService;
    }

    public List<Competition> getCompetitionList() {
        return competitionRepository.findAll();
    }

    public List<Competition> getCompetitionListByField(String field) {
        return competitionRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    @Override
    public Page<Competition> getCompetitionListWithPagination(int offset, int pageSize) {
        return competitionRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Optional<Competition> getCompetitionBycode(String code) {
        return competitionRepository.findById(code);
    }

    @Override
    public Ranking AssingMemberToCompetition(Long memberId, String codeComp) {
        Optional<Member> member = memberService.getMemberbyID(memberId);
        if (member.isEmpty()) {
            throw new IllegalArgumentException("The member its not correct");

        }
        Optional<Competition> competition = getCompetitionBycode(codeComp);
        if (competition.isEmpty()) {
            throw new IllegalArgumentException("Thi competition its not correct");

        }


        ValideBeofreAssigne(competition);

        if (comparison(competition.get().getDate(),competition.get().getStartTime())){
            throw new IllegalArgumentException("Competition its starting in less than 24h");
        }

        Ranking newRnk = Ranking.builder()
                .id(
                        RankId.builder()
                                .competitionCode(codeComp)
                                .memberNumber(memberId)

                                .build()
                )
                .score(0)
                .rank(0)
                .member(member.get())
                .competition(competition.get())
                .build();
        if (rankingService.findRankingByMember(newRnk.getMember()).isPresent()) {
            throw new IllegalArgumentException("This member already in this competition");
        }
        return rankingService.AddMemberToRanking(newRnk);
    }

    @Override
    public Competition CreateCompetition(Competition competition) {
        validateTime(competition);
        checkExistingCompetitions(competition);
        generateCompetitionCode(competition);


        return competitionRepository.save(competition);
    }

    private void generateCompetitionCode(Competition competition) {
        String date = competition.getDate().toString() ; // Remove hyphens from the date
        String location = competition.getLocation().replaceAll("-", "").replaceAll(" ",""); // Remove hyphens from the location


        String code = date +
                location.substring(0, Math.min(location.length(), 3));


        competition.setCode(code);

    }

    private void checkExistingCompetitions(Competition competition) {
        List<Competition> allComps = getCompetitionList();
        if (allComps.stream().anyMatch(comp -> comp.getDate() != null && comp.getDate().equals(competition.getDate()))) {
            throw new IllegalArgumentException("There's a Competition on the same day");
        }
    }

    private void validateTime(Competition competition) {
        LocalDate currentDate = LocalDate.now();

        if (competition.getDate().isBefore(currentDate)) {
            throw new IllegalArgumentException("You cannot create a competition in the past");

        }
        if (competition.getEndTime().isBefore(competition.getStartTime())) {
            throw new IllegalArgumentException("End Time cannot be before start");
        }

        if (!competition.getStartTime().plusHours(3).isBefore(competition.getEndTime())) {
            throw new IllegalArgumentException("Competition at least must be 3 hours");

        }
    }

    private void ValideBeofreAssigne(Optional<Competition> competition){

        if (competition.get().getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The competition its done");

        }
    }


    public boolean comparison(LocalDate date, LocalTime startTime){
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime competitionDateTime = LocalDateTime.of(date, startTime);
        Duration duration = Duration.between(currentDateTime, competitionDateTime);
        return Math.abs(duration.getSeconds()) < 86400;
    }


}
