package com.dongyoung.noAlone.board.entity;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT",length = 3000)
    private String content;

    @Column(name = "VIEWS", columnDefinition = "integer default 0",nullable = false)
    private Integer views = 0; //조회수

    @Embedded
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "board",cascade = CascadeType.PERSIST)
    private final List<Comment> comments = new ArrayList<>();
}
