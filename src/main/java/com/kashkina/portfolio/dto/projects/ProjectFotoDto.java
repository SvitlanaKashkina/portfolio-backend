package com.kashkina.portfolio.dto.projects;

public record ProjectFotoDto(
        Integer id,
        String imageUrl,
        String altText,
        Integer displayOrder
) {
}
