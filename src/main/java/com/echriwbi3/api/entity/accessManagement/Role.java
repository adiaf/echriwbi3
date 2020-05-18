package com.echriwbi3.api.entity.accessManagement;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.echriwbi3.api.entity.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Role extends CommonEntity {
    private String roleName;
}