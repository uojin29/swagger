package com.example.swagger.domain.service;

import com.example.swagger.domain.Member;
import com.example.swagger.domain.controller.response.MemberListResponse;
import com.example.swagger.domain.controller.response.MemberResponse;
import com.example.swagger.domain.dto.MemberDto;
import com.example.swagger.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void createMember(MemberDto memberDto) {
        Member member = Member.from(memberDto);
        memberRepository.save(member);
    }

    public MemberListResponse getMemberList() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponses = members.stream()
                .map(MemberResponse::new)
                .toList();
        return new MemberListResponse(memberResponses);
    }
}
