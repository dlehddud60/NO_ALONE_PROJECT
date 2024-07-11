package com.dongyoung.noAlone.board.entity;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.common.entity.BaseTimeEntity;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicInsert // 공부하기
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT", length = 3000)
    private String content;

    @Column(name = "VIEWS")
    private Integer views; //조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private final List<Comment> comments = new ArrayList<>();
}
