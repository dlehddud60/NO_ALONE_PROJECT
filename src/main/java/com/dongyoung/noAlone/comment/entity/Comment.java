package com.dongyoung.noAlone.comment.entity;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMMENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long commentId;

    @Column(name = "CONTENT", length = 1000)
    private String content;

    @Embedded
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;


}
