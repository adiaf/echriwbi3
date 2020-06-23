package com.echriwbi3.api.entity.projection;

import java.util.Date;

import com.echriwbi3.api.entity.Category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "exposedCategory", types = { Category.class })
public interface ExposedCategory {

    String getId();

    Date getCreated();

    Date getUpdated();

    String getName();

    String getDescription();

    Integer getCategoryLevel();

    boolean isEnabeled();

    @Value("#{target.getParentCategory() != null ? target.getParentCategory().getId() : null}")
    String getParentCategory();
}