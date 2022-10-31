package com.tdnhat.bookstore.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tdnhat.bookstore.product.entity.Book;
import com.tdnhat.bookstore.product.entity.ProductType;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Book} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto implements Serializable {
    private Long id;
    @Builder.Default
    private ProductType type = ProductType.BOOK;
    private double price;
    private String description;
    private CategoryDto category;
    private String title;
    private String author;
    private int releaseYear;
    private String isbn;

    public static BookDto from(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .category(CategoryDto.from(entity.getCategory()))
                .description(entity.getDescription())
                .releaseYear(entity.getReleaseYear())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .build();
    }
}