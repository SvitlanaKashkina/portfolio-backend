package com.kashkina.portfolio.dto.skills;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStackItemDTO {
    private Long id;
    private String name;
    private Integer orderIndex;
    private Long categoryId;
}
