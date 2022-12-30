package com.demo.portfolio.user.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MemberDto {
    public record MemberSignUpDto(
            @NotEmpty
            String username,
            String password,
            String name,
            @Email
            String email,
            String phone,
            @NotNull
            String gender,
            Integer age
    ) {
    }
}
