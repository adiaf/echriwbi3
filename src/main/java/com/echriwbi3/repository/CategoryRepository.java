package com.echriwbi3.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.echriwbi3.entity.Category;

@RepositoryRestResource
public interface CategoryRepository extends MongoRepository<Category, String>, QuerydslPredicateExecutor<Category> {
	@Override
	Optional<Category> findById(String id);

	Page<Category> findByEnabeledTrue(Pageable pageable);

	Page<Category> findByNameContainingAndEnabeledTrue(@Param("name") String name, Pageable pageable);

	Page<Category> findByCategoryLevelAndEnabeledTrue(@Param("level") Integer level, Pageable pageable);

	Page<Category> findByParentCategoryIdAndEnabeledTrue(@Param("categoryId") String categoryId, Pageable pageable);

	Page<Category> findByCategoryLevelAndNameContainingAndEnabeledTrue(@Param("level") Integer level,
			@Param("name") String name, Pageable pageable);

	Page<Category> findByParentCategoryIdAndCategoryLevelAndNameContainingAndEnabeledTrue(
			@Param("categoryId") Set<String> categoryIds, @Param("level") Integer level, @Param("name") String name,
			Pageable pageable);

	@Query("{ 'parentCategory.$id':{ '$in' :[{$oid : ?0}]},'categoryLevel':?1,'enabeled':true}")
	Page<Category> findByParentCategoryIdAndCategoryLevelAndEnabeledTrue(@Param("categoryId") Set<String> categoryIds,
			@Param("level") Integer level, Pageable pageable);

	Page<Category> findByParentCategoryIdAndNameContainingAndEnabeledTrue(@Param("categoryId") Set<String> categoryIds,
			@Param("name") String name, Pageable pageable);
}
