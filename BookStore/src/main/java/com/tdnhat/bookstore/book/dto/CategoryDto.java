package com.tdnhat.bookstore.book.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tdnhat.bookstore.book.entity.Category;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.tdnhat.bookstore.book.entity.Category} entity
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}