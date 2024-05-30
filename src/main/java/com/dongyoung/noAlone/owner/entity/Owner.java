package com.dongyoung.noAlone.owner.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OWNER")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OWNER_ID")
    private Long ownerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "RATING")
    private Rating rating;

    @Embedded
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEETING_ID")
    private Meeting meeting;
}
