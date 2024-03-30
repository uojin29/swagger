package com.example.swagger.domain.controller;

import com.example.swagger.domain.controller.request.MemberCreateRequest;
import com.example.swagger.domain.controller.request.MemberUpdateRequest;
import com.example.swagger.domain.controller.response.MemberListResponse;
import com.example.swagger.domain.dto.MemberDto;
import com.example.swagger.domain.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @Operation(summary = "모든 회원 조회")
    @GetMapping
    public ResponseEntity<MemberListResponse> getAllMembers() {
        MemberListResponse memberListResponse = memberService.getMemberList();
        return ResponseEntity.ok().body(memberListResponse);
    }
    @Operation(summary = "회원 생성")
    @PostMapping("/create")
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        memberService.createMember(MemberDto.from(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "회원 조회")
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("id") Long memberId) {
        MemberDto memberDto = memberService.findByMemberId(memberId);
        return ResponseEntity.ok().body(memberDto);
    }
    @Operation(summary = "회원 수정")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable("id") Long memberId, @RequestBody MemberUpdateRequest request) {
        memberService.update(memberId, MemberDto.from(request));
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "회원 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.ok().build();
    }
}