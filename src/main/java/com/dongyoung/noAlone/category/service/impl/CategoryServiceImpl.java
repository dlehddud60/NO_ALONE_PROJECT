package com.dongyoung.noAlone.category.service.impl;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.*;
import com.dongyoung.noAlone.category.model.mapper.CategoryMapper;
import com.dongyoung.noAlone.category.repository.CategoryRepository;
import com.dongyoung.noAlone.category.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<FindResponseCategoryListModel> findAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryListModel).collect(Collectors.toList());
    }

    @Override
    public Page<FindResponseCategoryListModel> findAllbyQueryDsl(SearchCondition search, Pageable pageable) {
        return categoryRepository.findAllbyQueryDsl(search, pageable);
    }

    @Override
    public FindResponseCategoryModel find(Long categoryId) {
        return categoryMapper.toCategoryModel(categoryRepository.findByCategoryId(categoryId));
    }

    @Override
    public void save(InsertRequestCategoryModel categoryModel) {
        Category category = Category.builder()
                .name(categoryModel.name())
                .description(categoryModel.description())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public void update(UpdateRequestCategoryModel categoryModel) {
        Category category = categoryRepository.findByCategoryId(categoryModel.categoryId());
        category.setName(categoryModel.name());
        category.setDescription(categoryModel.description());
    }

    @Override
    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
