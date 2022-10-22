package com.tdnhat.bookstore.user.dto;

import com.tdnhat.bookstore.user.entity.Permission;
import com.tdnhat.bookstore.user.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Role} entity
 */
@Getter
@Setter
public class RoleDto implements Serializable {
    private Long id;
    private String name;
    private List<Permission> permissions;
}