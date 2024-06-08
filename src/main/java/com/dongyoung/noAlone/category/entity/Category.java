package com.dongyoung.noAlone.category.entity;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.common.entity.DateTime;
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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private DateTime dateTime;

    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private final List<Board> boards = new ArrayList<>();

}
