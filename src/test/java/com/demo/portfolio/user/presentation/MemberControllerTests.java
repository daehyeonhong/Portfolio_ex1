package com.demo.portfolio.user.presentation;

import com.demo.portfolio.common.TestCommonConfig;
import com.demo.portfolio.user.domain.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class MemberControllerTests extends TestCommonConfig {
    @Test
    @DisplayName(value = "회원가입 테스트")
    void signUp() throws Exception {
        final String content = objectMapper.writeValueAsString(new MemberDto.MemberSignUpDto(
                UUID.randomUUID().toString().substring(24),
                "1q12w!",
                "김감자",
                "asd@masad.com",
                "01022340042",
                "M",
                23));
        System.out.println(content);
        mockMvc.perform(post("/members")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(print());
    }
}
