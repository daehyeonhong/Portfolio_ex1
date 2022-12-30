package com.demo.portfolio.user.application;

import com.demo.portfolio.user.domain.MemberEntity;
import com.demo.portfolio.user.domain.dto.MemberDto;

public interface MemberService {
    MemberEntity findById(Long id);

    Long save(MemberDto.MemberSignUpDto memberSignUpDto);
}
