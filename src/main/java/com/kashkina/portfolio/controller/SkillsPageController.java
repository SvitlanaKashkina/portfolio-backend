package com.kashkina.portfolio.controller;

import com.kashkina.portfolio.dto.skills.SkillsPageDTO;
import com.kashkina.portfolio.service.SkillsPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillsPageController {

    private final SkillsPageService skillsPageService;

    @GetMapping
    public SkillsPageDTO getSkillsPage() {
        return skillsPageService.getAllSkills();
    }
}

