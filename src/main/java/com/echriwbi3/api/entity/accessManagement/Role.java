package com.echriwbi3.api.entity.accessManagement;

import com.echriwbi3.api.entity.CommonEntity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "roles")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Role extends CommonEntity {
    @Field(name = "roleName")
    private String roleName;
}