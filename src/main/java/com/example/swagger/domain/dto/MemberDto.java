package com.example.swagger.domain.dto;

import com.example.swagger.domain.Member;
import com.example.swagger.domain.controller.request.MemberCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MemberDto {
    private Long id;
    private String name;
    private String email;

    public MemberDto(MemberCreateRequest memberCreateRequest) {
        this.name = memberCreateRequest.getName();
        this.email = memberCreateRequest.getEmail();
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
    public static MemberDto from(MemberCreateRequest memberCreateRequest) {
        return MemberDto.builder()
                .name(memberCreateRequest.getName())
                .email(memberCreateRequest.getEmail())
                .build();
    }
}
