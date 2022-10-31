package com.tdnhat.bookstore.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tdnhat.bookstore.product.entity.Accessory;
import com.tdnhat.bookstore.product.entity.ProductType;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.tdnhat.bookstore.product.entity.Accessory} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessoryDto implements Serializable {
    private Long id;
    @Builder.Default
    private ProductType type = ProductType.ACCESSORY;
    private double price;
    private String description;
    private CategoryDto category;
    private String name;

    public static AccessoryDto from(Accessory entity) {
        return AccessoryDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .category(CategoryDto.from(entity.getCategory()))
                .name(entity.getName())
                .build();
    }
}