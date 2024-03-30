package com.example.swagger.domain.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberCreateRequest {
    @Schema(description = "이름", example = "장유진")
    private String name;
    @Schema(description = "이메일", example = "22000631@handong.ac.kr")
    private String email;
}
