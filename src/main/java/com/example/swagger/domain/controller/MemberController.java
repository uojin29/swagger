package com.example.swagger.domain.controller;

import com.example.swagger.domain.controller.request.MemberCreateRequest;
import com.example.swagger.domain.controller.response.MemberListResponse;
import com.example.swagger.domain.dto.MemberDto;
import com.example.swagger.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping
    public ResponseEntity<MemberListResponse> getAllMembers() {
        MemberListResponse memberListResponse = memberService.getMemberList();
        return ResponseEntity.ok().body(memberListResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        memberService.createMember(MemberDto.from(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("id") Long memberId) {
        MemberDto memberDto = memberService.findByMemberId(memberId);
        return ResponseEntity.ok().body(memberDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable("id") Long memberId, @RequestBody MemberCreateRequest request) {
        memberService.update(memberId, MemberDto.from(request));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.ok().build();
    }
}