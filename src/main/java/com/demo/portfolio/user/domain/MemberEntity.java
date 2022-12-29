package com.demo.portfolio.user.domain;

import com.demo.portfolio.base.domain.BaseEntity;
import com.demo.portfolio.user.domain.enumerate.Gender;
import com.demo.portfolio.user.domain.enumerate.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member", indexes = {@Index(name = "idx_username", columnList = "username"), @Index(name = "idx_phone", columnList = "phone")})
public class MemberEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, updatable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String phone;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Enumerated(EnumType.STRING)
    Role role;
    @Column(nullable = false)
    Integer age;
    @Column(nullable = false)
    boolean activated;

    @Builder
    private MemberEntity(final String username, final String password, final String name, final String email, final String phone, final Gender gender, final Role role, final Integer age, final boolean activated) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
        this.age = age;
        this.activated = activated;
    }
}
