package com.dongyoung.noAlone.like.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LIKES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKES_ID")
    private Long likesId;

    @Embedded
    private DateTime dateTime;

}
