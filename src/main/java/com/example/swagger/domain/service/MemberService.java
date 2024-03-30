package com.example.swagger.domain.service;

import com.example.swagger.domain.Member;
import com.example.swagger.domain.controller.response.MemberListResponse;
import com.example.swagger.domain.controller.response.MemberResponse;
import com.example.swagger.domain.dto.MemberDto;
import com.example.swagger.domain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberDto memberDto) {
        Member member = Member.from(memberDto);
        memberRepository.save(member);
    }
    @Transactional
    public MemberListResponse getMemberList() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponses = members.stream()
                .map(MemberResponse::new)
                .toList();
        return new MemberListResponse(memberResponses);
    }
    @Transactional
    public MemberDto findByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return MemberDto.from(member);
    }
    @Transactional
    public void update(Long memberId, MemberDto memberDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        member.update(memberDto);
        memberRepository.save(member);
    }
}
