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

    @GetMapping("/member/updateForm/{id}")
    public String updateForm(@ModelAttribute("id") Long memberId, Model model){
        MemberDto memberDto = memberService.findByMemberId(memberId);
        model.addAttribute("member", memberDto);
        return "memberUpdateForm";
    }
    @PostMapping("/member/updateForm/{id}")
    public String update(@ModelAttribute("id") Long memberId, @ModelAttribute("member") MemberCreateRequest request){
        memberService.update(memberId, MemberDto.from(request));
        return "redirect:/member/memberList";
    }

    @GetMapping("/member/delete/{id}")
    public String delete(@ModelAttribute("id") Long memberId){
        memberService.delete(memberId);
        return "redirect:/member/memberList";
    }
}
