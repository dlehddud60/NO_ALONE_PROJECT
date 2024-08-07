package com.dongyoung.noAlone.meeting.entity;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.common.entity.BaseTimeEntity;
import com.dongyoung.noAlone.owner.entity.Owner;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEETING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Meeting extends BaseTimeEntity {

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

    @OneToOne(mappedBy = "meeting", cascade = CascadeType.PERSIST)
    private Owner owner;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.PERSIST)
    private final List<Accept> accepts = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
