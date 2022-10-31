package com.tdnhat.bookstore.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tdnhat.bookstore.util.ISBNUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Product {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Builder.Default
    @Column(name = "isbn", nullable = false)
    private String isbn = ISBNUtils.generate();
}
