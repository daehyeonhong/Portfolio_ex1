package com.demo.portfolio.user.application;

import com.demo.portfolio.user.domain.MemberEntity;
import com.demo.portfolio.user.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberEntity findById(final Long id) {
        return this.memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public MemberEntity save(final MemberEntity member) {
        return this.memberRepository.save(member);
    }
}
