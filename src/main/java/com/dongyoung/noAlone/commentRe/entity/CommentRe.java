package com.dongyoung.noAlone.commentRe.entity;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentId")
    private Comment comment;




}
