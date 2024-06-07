package com.dongyoung.noAlone.category.repository;

import com.dongyoung.noAlone.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryId(Long name);
}
