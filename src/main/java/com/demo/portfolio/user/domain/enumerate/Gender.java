package com.demo.portfolio.user.domain.enumerate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Gender {
    MALE("남성"), FEMALE("여성"), NONE("없음");
    final String description;

    public static Gender of(final String gender) {
        return switch (gender) {
            case "M" -> Gender.MALE;
            case "F" -> Gender.FEMALE;
            default -> Gender.NONE;
        };
    }
}
