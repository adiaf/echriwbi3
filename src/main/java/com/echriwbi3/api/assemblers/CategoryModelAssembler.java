package com.echriwbi3.api.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.echriwbi3.api.controllers.CategoryRestController;
import com.echriwbi3.api.entity.Category;
import com.echriwbi3.api.model.CategoryModel;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CategoryModelAssembler extends RepresentationModelAssemblerSupport<Category, CategoryModel> {

    public CategoryModelAssembler() {
        super(CategoryRestController.class, CategoryModel.class);
    }

    @Override
    public CategoryModel toModel(Category entity) {
        CategoryModel model = instantiateModel(entity);

        model.add(linkTo(methodOn(CategoryRestController.class).getCategoryById(entity.getId())).withSelfRel());

        model.setId(entity.getId());
        model.setCreated(entity.getCreated());
        model.setUpdated(entity.getUpdated());
        model.setVersion(entity.getVersion());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setParentCategory(entity.getParentCategory());
        model.setCategoryLevel(entity.getCategoryLevel());
        model.setEnabeled(entity.isEnabeled());
        return model;
    }

    @Override
    public CollectionModel<CategoryModel> toCollectionModel(Iterable<? extends Category> entities) {
        CollectionModel<CategoryModel> models = super.toCollectionModel(entities);

        models.add(linkTo(methodOn(CategoryRestController.class).getAllcategories()).withSelfRel());

        return models;
    }
}
