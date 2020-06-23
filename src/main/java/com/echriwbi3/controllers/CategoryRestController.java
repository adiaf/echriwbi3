package com.echriwbi3.api.controllers;

import java.util.List;

import com.echriwbi3.api.assemblers.CategoryModelAssembler;
import com.echriwbi3.api.entity.Category;
import com.echriwbi3.api.model.CategoryModel;
import com.echriwbi3.api.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RepositoryRestController
public class CategoryRestController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryModelAssembler categoryModelAssembler;

	@Autowired
	private PagedResourcesAssembler<Category> pagedResourcesAssembler;

	@CrossOrigin
	@RequestMapping(value = "/categories/search/listProducers", method = RequestMethod.GET)
	public ResponseEntity<PagedModel<CategoryModel>> getFiltered(Pageable pageable) {
		Page<Category> cats = categoryRepository.findAll(pageable);
		// for (final Category cat : cats) {

		// Link link =
		// WebMvcLinkBuilder.linkTo(CategoryRestController.class).slash(cat.getId()).withSelfRel();
		// cat.add(link);
		// }

		PagedModel<CategoryModel> model = pagedResourcesAssembler.toModel(cats, categoryModelAssembler);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@GetMapping("/categories/searchById/{id}")
	public ResponseEntity<CategoryModel> getCategoryById(@PathVariable("id") String id) {
		return categoryRepository.findById(id).map(categoryModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/categories/getAllcategories")
	public ResponseEntity<CollectionModel<CategoryModel>> getAllcategories() {
		List<Category> albumEntities = (List<Category>) categoryRepository.findAll();

		return new ResponseEntity<>(categoryModelAssembler.toCollectionModel(albumEntities), HttpStatus.OK);
	}

}
