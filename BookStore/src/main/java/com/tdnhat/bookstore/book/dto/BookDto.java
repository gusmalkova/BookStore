package com.tdnhat.bookstore.book.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tdnhat.bookstore.book.entity.Book;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.tdnhat.bookstore.book.entity.Book} entity
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto implements Serializable {
    private Long id;
    private String title;
    private String author;
    private int releaseYear;
    private int isbn;
    private double price;
    private String description;
    private CategoryDto category;

    public static BookDto fromEntity(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .releaseYear(book.getReleaseYear())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .description(book.getDescription())
                .category(CategoryDto.fromEntity(book.getCategory()))
                .build();
    }
}