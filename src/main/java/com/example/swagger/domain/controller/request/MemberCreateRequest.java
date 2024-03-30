package com.example.swagger.domain.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberCreateRequest {
    private String name;
    private String email;
}
