package com.demo.portfolio.user.presentation;

import com.demo.portfolio.user.application.MemberService;
import com.demo.portfolio.user.domain.MemberEntity;
import com.demo.portfolio.user.domain.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/members")
    public ResponseEntity<String> signUp(@RequestBody final MemberSignUpDto memberSignUpDto) {
        final MemberEntity save = this.memberService.save(MemberEntity.builder()
                .username(memberSignUpDto.username())
                .password(memberSignUpDto.password())
                .name(memberSignUpDto.name())
                .email(memberSignUpDto.email())
                .phone(memberSignUpDto.phone())
                .gender(memberSignUpDto.gender())
                .role(memberSignUpDto.role())
                .age(memberSignUpDto.age())
                .activated(memberSignUpDto.activated())
                .build()
        );

        log.info("{}", this.memberService.findById(save.getId()));
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<String> index() {
        return ResponseEntity.of(Optional.of("ok"));
    }
}
