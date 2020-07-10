package com.echriwbi3.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.echriwbi3.model.blog.Article;
import com.echriwbi3.model.blog.Category;
import com.echriwbi3.model.blog.CategoryDTO;
import com.echriwbi3.model.blog.Tag;
import com.echriwbi3.repository.BlogArticleRepository;
import com.echriwbi3.repository.BlogCategoryRepository;
import com.echriwbi3.repository.BlogTagRepository;
import com.querydsl.core.types.Predicate;

@Service
public class BlogService {
	@Autowired
	BlogArticleRepository blogArticleRepository;

	@Autowired
	BlogCategoryRepository blogCategoryRepository;

	@Autowired
	BlogTagRepository blogTagRepository;

	public Page<Category> findShownOnMenuCategories() {

		final com.echriwbi3.model.blog.QCategory qCategory = new com.echriwbi3.model.blog.QCategory("user");

		final Predicate predicate = qCategory.showOnMenu.eq(true).and(qCategory.enabled.eq(true));
		final Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by("order"));
		return blogCategoryRepository.findAll(predicate, pageable);

	}

	public Page<Article> findArticlesEnVedette() {
		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		final Predicate predicate = qArticle.enVedette.eq(true).and(qArticle.enabled.eq(true));
		final Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by("created").descending());
		return blogArticleRepository.findAll(predicate, pageable);

	}

	public Page<Article> findRecentPosts(int number) {
		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		final Predicate predicate = qArticle.enabled.eq(true);
		final Pageable pageable = PageRequest.of(0, number, Sort.by("created").descending());

		return blogArticleRepository.findAll(predicate, pageable);

	}

	public Page<Article> findFeaturedPosts(int number) {

		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		final Predicate predicate = qArticle.featured.eq(true).and(qArticle.enabled.eq(true));
		final Pageable pageable = PageRequest.of(0, number, Sort.by("created").descending());

		return blogArticleRepository.findAll(predicate, pageable);
	}

	public Page<Article> findMostReadPosts(int number) {
		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		final Predicate predicate = qArticle.enabled.eq(true);
		final Pageable pageable = PageRequest.of(0, number, Sort.by("read").descending());

		return blogArticleRepository.findAll(predicate, pageable);
	}

	public Optional<Article> findPostById(String id) {
		return blogArticleRepository.findById(id);
	}

	public List<CategoryDTO> findAllCategories() {
		final com.echriwbi3.model.blog.QCategory qCategory = new com.echriwbi3.model.blog.QCategory("user");
		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		final Predicate predicate = qCategory.enabled.eq(true);

		List<Category> cats = (List<Category>) blogCategoryRepository.findAll(predicate);

		return cats.stream().map(c -> {

			final Predicate aPredicate = qArticle.category.id.eq(c.getId()).and(qArticle.enabled.eq(true));
			return new CategoryDTO(c.getId(), c.getTitle(), c.getSlug(), c.getColor(),
					blogArticleRepository.count(aPredicate));
		}).filter(c -> c.getArticlesCount() > 0).sorted(Comparator.comparing(CategoryDTO::getArticlesCount).reversed())
				.collect(Collectors.toList());

	}

	public List<Tag> findAllTags() {
		final com.echriwbi3.model.blog.QTag qTag = new com.echriwbi3.model.blog.QTag("user");
		final com.echriwbi3.model.blog.QArticle qArticle = new com.echriwbi3.model.blog.QArticle("user");

		List<Tag> tags = blogTagRepository.findAll();
		return tags.stream().filter(t -> {
			final Predicate aPredicate = qArticle.tags.contains(t).and(qArticle.enabled.eq(true));
			return blogArticleRepository.count(aPredicate) > 0;

		}).collect(Collectors.toList());
	}
}
