package com.dongyoung.noAlone.accept.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACCEPT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Accept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCEPT_ID")
    private Long acceptId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "ABOUT_ME")
    private String aboutMe;

    @Column(name = "COMPANION_REASON")
    private String companionReason;

    @Embedded
    private DateTime dateTime;

}
