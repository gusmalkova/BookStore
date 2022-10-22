package com.tdnhat.bookstore.user.dto;

import com.tdnhat.bookstore.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link User} entity
 */
@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Set<RoleDto> role;
}