package com.echriwbi3.api.repository;

import java.util.Set;

import com.echriwbi3.api.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
        Page<Category> findByEnabeledTrue(Pageable pageable);

        Page<Category> findByNameContainingAndEnabeledTrue(@Param("name") String name, Pageable pageable);

        Page<Category> findByCategoryLevelAndEnabeledTrue(@Param("level") Integer level, Pageable pageable);

        Page<Category> findByParentCategoryIdAndEnabeledTrue(@Param("categoryId") Long categoryId, Pageable pageable);

        Page<Category> findByCategoryLevelAndNameContainingAndEnabeledTrue(@Param("level") Integer level,
                        @Param("name") String name, Pageable pageable);

        Page<Category> findByParentCategoryIdInAndCategoryLevelAndNameContainingAndEnabeledTrue(
                        @Param("categoryIds") Set<Long> categoryIds, @Param("level") Integer level,
                        @Param("name") String name, Pageable pageable);

        Page<Category> findByParentCategoryIdInAndCategoryLevelAndEnabeledTrue(
                        @Param("categoryIds") Set<Long> categoryIds, @Param("level") Integer level, Pageable pageable);

        Page<Category> findByParentCategoryIdInAndNameContainingAndEnabeledTrue(
                        @Param("categoryIds") Set<Long> categoryIds, @Param("name") String name, Pageable pageable);
}
