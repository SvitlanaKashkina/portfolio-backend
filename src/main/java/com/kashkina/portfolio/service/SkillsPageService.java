package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.skills.*;
import com.kashkina.portfolio.entity.skills.SoftSkill;
import com.kashkina.portfolio.entity.skills.TechStackCategory;
import com.kashkina.portfolio.entity.skills.TechnicalSkillCategory;
import com.kashkina.portfolio.repository.skills.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillsPageService {
    private final SoftSkillRepository softSkillRepo;
    private final TechStackCategoryRepository techStackCatRepo;
    private final TechStackItemRepository techStackItemRepo;
    private final TechnicalSkillCategoryRepository techCatRepo;
    private final TechnicalSkillItemRepository techItemRepo;

    public SkillsPageDTO getAllSkills() {

        // --- Tech Stack ---
        List<TechStackCategoryDTO> techStack = techStackCatRepo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(TechStackCategory::getOrderIndex))
                .map(c -> {
                    List<TechStackItemDTO> items = techStackItemRepo.findByCategoryIdOrderByOrderIndexAsc(c.getId())
                            .stream()
                            .map(i -> new TechStackItemDTO(i.getId(), i.getName(), i.getOrderIndex(), c.getId()))
                            .collect(Collectors.toList());
                    return new TechStackCategoryDTO(c.getId(), c.getName(), c.getOrderIndex(), items);
                })
                .collect(Collectors.toList());

        // --- Technical Skills ---
        List<TechnicalSkillCategoryDTO> technicalSkills = techCatRepo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(TechnicalSkillCategory::getOrderIndex))
                .map(cat -> {
                    List<TechnicalSkillItemDTO> items = techItemRepo.findByCategoryIdOrderByOrderIndexAsc(cat.getId())
                            .stream()
                            .map(i -> new TechnicalSkillItemDTO(i.getId(), i.getDescription(), i.getOrderIndex(), cat.getId()))
                            .collect(Collectors.toList());
                    return new TechnicalSkillCategoryDTO(cat.getId(), cat.getName(), cat.getOrderIndex(), items);
                })
                .collect(Collectors.toList());

        // --- Soft Skills ---
        List<SoftSkillDTO> softSkills = softSkillRepo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(SoftSkill::getOrderIndex))
                .map(s -> new SoftSkillDTO(s.getId(), s.getName(), s.getOrderIndex()))
                .collect(Collectors.toList());

        // --- Collect all in SkillsPageDTO ---
        return new SkillsPageDTO(techStack, technicalSkills, softSkills);
    }
}
