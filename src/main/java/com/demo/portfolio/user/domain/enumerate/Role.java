package com.demo.portfolio.user.domain.enumerate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Role {
    ADMIN("ROLE_ADMIN", "관리자"), USER("ROLE_USER", "회원"), GUEST("ROLE_GUEST", "비회원");
    final String key;
    final String title;

    public static Role of(final String key) {
        return Arrays.stream(Role.values())
                .filter(a -> a.getKey().equals(key))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
