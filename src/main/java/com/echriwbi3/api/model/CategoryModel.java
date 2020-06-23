package com.echriwbi3.api.model;

import java.util.Date;

import com.echriwbi3.api.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "categories", itemRelation = "category")
@JsonInclude(Include.NON_NULL)
public class CategoryModel extends RepresentationModel<CategoryModel> {
    private String id;

    private Date created;

    private Date updated;

    private Long version;

    private String name;

    private String description;

    private Category parentCategory;

    private Integer categoryLevel;

    private boolean enabeled;
}