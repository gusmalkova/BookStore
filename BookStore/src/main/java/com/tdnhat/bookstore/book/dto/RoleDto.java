package com.tdnhat.bookstore.book.dto;

import com.tdnhat.bookstore.book.entity.Permission;
import com.tdnhat.bookstore.book.entity.Role;
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