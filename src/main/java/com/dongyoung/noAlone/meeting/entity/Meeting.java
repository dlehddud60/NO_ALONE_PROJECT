package com.dongyoung.noAlone.meeting.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEETING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID")
    private Long meetingId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTENT", length = 1000)
    private String content;

    @Column(name = "RULE")
    private String rule;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "OWNER")
    private String owner;

    @Embedded
    private DateTime dateTime;
}
