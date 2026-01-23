package com.kashkina.portfolio.dto.skills;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoftSkillDTO {
    private Long id;
    private String name;
    private Integer orderIndex;
}
