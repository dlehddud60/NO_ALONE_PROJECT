package com.dongyoung.noAlone.mbti.entity;

import com.dongyoung.common.entity.DateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MBTI")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Mbti {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MBTI_ID")
    private Long mbtiId;

    @Column(name = "NAME", unique = true)
    private String name;

    @Embedded
    private DateTime dateTime;
}
