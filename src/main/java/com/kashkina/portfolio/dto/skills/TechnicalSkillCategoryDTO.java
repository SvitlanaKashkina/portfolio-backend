package com.kashkina.portfolio.dto.skills;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalSkillCategoryDTO {

    private Long id;
    private String name;
    private Integer orderIndex;
    private List<TechnicalSkillItemDTO> items;
}
