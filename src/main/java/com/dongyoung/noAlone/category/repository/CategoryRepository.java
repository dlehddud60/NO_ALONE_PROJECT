package com.dongyoung.noAlone.category.repository;

import com.dongyoung.noAlone.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category, Long> , CategoryQueryRepository {
    Category findByCategoryId(Long categoryId);
}
