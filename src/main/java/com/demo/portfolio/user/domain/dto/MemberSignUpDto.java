package com.demo.portfolio.user.domain.dto;

import com.demo.portfolio.user.domain.enumerate.Gender;
import com.demo.portfolio.user.domain.enumerate.Role;

public record MemberSignUpDto(String username, String password, String name, String email, String phone, Gender gender,
                              Role role, Integer age, boolean activated) {
}
