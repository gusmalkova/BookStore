package com.tdnhat.bookstore.book.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.tdnhat.bookstore.book.entity.User} entity
 */
@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Set<RoleDto> role;
}