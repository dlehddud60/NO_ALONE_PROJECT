package com.dongyoung.noAlone.member.entity;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL" ,unique = true)
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
    private Role role;

    @Embedded
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MBTI_ID")
    private Mbti mbti;

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    private final List<Owner> owners = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    private final List<Accept> accepts = new ArrayList<>();

}
