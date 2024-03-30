package com.example.swagger.domain.controller.response;

import com.example.swagger.domain.dto.MemberDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberCreateResponse {
    private Long id;
    private String member_name;
    private String email;
    private String uniqueId;

    public MemberCreateResponse(MemberDto memberDto) {
        this.id = memberDto.getId();
        this.member_name = memberDto.getName();
        this.email = memberDto.getEmail();
    }
}
