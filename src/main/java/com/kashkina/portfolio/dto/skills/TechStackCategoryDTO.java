package com.kashkina.portfolio.dto.skills;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TechStackCategoryDTO {
    private Long id;
    private String name;
    private Integer orderIndex;
    private List<TechStackItemDTO> items;

    public TechStackCategoryDTO(Long id, String name, Integer orderIndex, List<TechStackItemDTO> items) {
        this.id = id;
        this.name = name;
        this.orderIndex = orderIndex;
        this.items = items;
    }
}
