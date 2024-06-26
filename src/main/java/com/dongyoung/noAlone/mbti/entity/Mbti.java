package com.dongyoung.noAlone.mbti.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MBTI")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Mbti {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MBTI_ID")
    private Long mbtiId;

    @Column(name = "NAME",unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private DateTime dateTime;

    @OneToMany(mappedBy = "mbti",cascade = CascadeType.PERSIST)
    private final List<Member> members = new ArrayList<>();
}
