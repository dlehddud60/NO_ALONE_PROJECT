package com.dongyoung.noAlone.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "ID",unique = true)
    private String id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private int age;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @Column(name = "PROFILE_IMAGE")
    private String profileImage;

    @Column(name = "BIRTHYEAR")
    private String birthyear;

    @Column(name = "MOBILE")
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private ROLE role;

    @Column(name = "INPUT_DT")
    private String inputDt;

    @Column(name = "UPDATE_DT")
    private String updateDt;
}
