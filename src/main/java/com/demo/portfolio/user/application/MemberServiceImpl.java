package com.demo.portfolio.user.application;

import com.demo.portfolio.user.domain.MemberEntity;
import com.demo.portfolio.user.domain.dto.MemberDto;
import com.demo.portfolio.user.domain.enumerate.Gender;
import com.demo.portfolio.user.domain.enumerate.Role;
import com.demo.portfolio.user.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberEntity findById(final Long id) {
        return this.memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public MemberEntity save(final MemberDto.MemberSignUpDto memberSignUpDto) {
        return this.memberRepository.save(MemberEntity.builder()
                .username(memberSignUpDto.username())
                .password(memberSignUpDto.password())
                .name(memberSignUpDto.name())
                .email(memberSignUpDto.email())
                .phone(memberSignUpDto.phone())
                .gender(Gender.of(memberSignUpDto.gender()))
                .role(Role.USER)
                .age(memberSignUpDto.age())
                .activated(true)
                .build());
    }
}
