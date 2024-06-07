package com.dongyoung.noAlone.category.repository.impl;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.entity.QCategory;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.SearchCondition;
import com.dongyoung.noAlone.category.model.mapper.CategoryMapper;
import com.dongyoung.noAlone.category.repository.CategoryQueryRepository;
import com.dongyoung.noAlone.category.repository.CategoryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.dongyoung.noAlone.category.entity.QCategory.category;

@RequiredArgsConstructor
@Repository
public class CategoryQueryRepositoryImpl implements CategoryQueryRepository {
    private final JPAQueryFactory queryFactory;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<FindResponseCategoryListModel> findAllbyQueryDsl(SearchCondition search, Pageable pageable) {
        List<Category> list = queryFactory.selectFrom(category)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(search(search.name()))
                .orderBy(category.categoryId.desc())
                .fetch();

        JPAQuery<Long> count = queryFactory.select(Wildcard.count).from(category);

        return PageableExecutionUtils.getPage(list.stream().map(categoryMapper::toCategoryListModel).collect(Collectors.toList()),pageable,count::fetchCount);
    }

    private BooleanExpression search (String search) {
        return search != null ? category.name.contains(search) : null;
    }
}
