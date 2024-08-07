package com.dongyoung.noAlone.category.entity;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.common.entity.BaseTimeEntity;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private final List<Board> boards = new ArrayList<>();

    @OneToOne(mappedBy = "category", cascade = CascadeType.PERSIST)
    private Meeting meeting;

}
