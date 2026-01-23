package com.kashkina.portfolio.dto.skills;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillsPageDTO {
    private List<TechStackCategoryDTO> techStack;
    private List<TechnicalSkillCategoryDTO> technicalSkills;
    private List<SoftSkillDTO> softSkills;
}
