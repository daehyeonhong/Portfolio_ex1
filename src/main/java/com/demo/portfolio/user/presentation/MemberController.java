package com.demo.portfolio.user.presentation;

import com.demo.portfolio.user.application.MemberService;
import com.demo.portfolio.user.domain.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/members")
    public ResponseEntity<String> signUp(@Validated @RequestBody final MemberDto.MemberSignUpDto memberSignUpDto) {
        return new ResponseEntity<>(String.valueOf(this.memberService.save(memberSignUpDto)), HttpStatus.CREATED);
    }
}
