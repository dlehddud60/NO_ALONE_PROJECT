package com.dongyoung.noAlone.commentRe.entity;

import com.dongyoung.noAlone.common.entity.DateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMMENT_RE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentRe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_RE_ID")
    private Long commentReId;

    @Column(name = "CONTENT", length = 1000)
    private String content;

    @Embedded
    private DateTime dateTime;
}
