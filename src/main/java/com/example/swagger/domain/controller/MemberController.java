package com.example.swagger.domain.controller;

import com.example.swagger.domain.controller.request.MemberCreateRequest;
import com.example.swagger.domain.controller.response.MemberListResponse;
import com.example.swagger.domain.dto.MemberDto;
import com.example.swagger.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/memberList")
    public String findMemberList(Model model){
        MemberListResponse memberListResponse = memberService.getMemberList();
        model.addAttribute("members", memberListResponse.getMembers());
        return "memberList";
    }

    @GetMapping("/member/memberForm")
    public String createMemberForm(Model model){
        model.addAttribute("member", new MemberCreateRequest());
        return "memberForm";
    }

    @PostMapping("/member/memberForm")
    public String createMember(@ModelAttribute("memberForm") MemberCreateRequest request ){
        memberService.createMember(MemberDto.from(request));
        return "redirect:/member/memberList";
    }
}