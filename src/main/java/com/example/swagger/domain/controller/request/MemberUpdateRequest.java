package com.example.swagger.domain.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberUpdateRequest {
    @Schema(description = "이름", example = "이정명")
    private String name;
    @Schema(description = "이메일", example = "dlwjdaud@handong.ac.kr")
    private String email;
}
