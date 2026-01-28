package com.kashkina.portfolio.unit.controllers;

import com.kashkina.portfolio.controller.SkillsPageController;
import com.kashkina.portfolio.dto.skills.*;
import com.kashkina.portfolio.service.SkillsPageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SkillsPageControllerTest {

    private SkillsPageController controller;
    private SkillsPageService skillsPageService;

    @BeforeEach
    void setUp() {
        skillsPageService = mock(SkillsPageService.class);
        controller = new SkillsPageController(skillsPageService);
    }

    @Test
    void testGetSkillsPage_WithData() {
        // Preparing TechStack
        TechStackItemDTO techItem1 = new TechStackItemDTO(1L, "Java", 1, 1L);
        TechStackCategoryDTO techCategory = new TechStackCategoryDTO(1L, "Backend", 1, List.of(techItem1));

        // Preparing Technical Skills
        TechnicalSkillItemDTO skillItem1 = new TechnicalSkillItemDTO(1L, "Spring Boot", 1, 1L);
        TechnicalSkillCategoryDTO techSkillCategory = new TechnicalSkillCategoryDTO(1L, "Backend Skills", 1, List.of(skillItem1));

        // Preparing Soft Skills
        SoftSkillDTO softSkill = new SoftSkillDTO(1L, "Teamwork", 1);

        // Preparing SkillsPageDTO
        SkillsPageDTO skillsPage = SkillsPageDTO.builder()
                .techStack(List.of(techCategory))
                .technicalSkills(List.of(techSkillCategory))
                .softSkills(List.of(softSkill))
                .build();

        // Setting up a mock: the service returns a DTO
        when(skillsPageService.getAllSkills()).thenReturn(skillsPage);

        // Calling the controller
        SkillsPageDTO result = controller.getSkillsPage();

        // check the result
        assertNotNull(result);
        assertEquals(1, result.getTechStack().size());
        assertEquals("Backend", result.getTechStack().get(0).getName());
        assertEquals(1, result.getTechStack().get(0).getItems().size());
        assertEquals("Java", result.getTechStack().get(0).getItems().get(0).getName());

        assertEquals(1, result.getTechnicalSkills().size());
        assertEquals("Backend Skills", result.getTechnicalSkills().get(0).getName());
        assertEquals(1, result.getTechnicalSkills().get(0).getItems().size());
        assertEquals("Spring Boot", result.getTechnicalSkills().get(0).getItems().get(0).getDescription());

        assertEquals(1, result.getSoftSkills().size());
        assertEquals("Teamwork", result.getSoftSkills().get(0).getName());

        verify(skillsPageService, times(1)).getAllSkills();
    }

    @Test
    void testGetSkillsPage_EmptyData() {
        // prepare an empty DTO
        SkillsPageDTO skillsPage = SkillsPageDTO.builder()
                .techStack(List.of())
                .technicalSkills(List.of())
                .softSkills(List.of())
                .build();

        when(skillsPageService.getAllSkills()).thenReturn(skillsPage);

        SkillsPageDTO result = controller.getSkillsPage();

        assertNotNull(result);
        assertTrue(result.getTechStack().isEmpty());
        assertTrue(result.getTechnicalSkills().isEmpty());
        assertTrue(result.getSoftSkills().isEmpty());

        verify(skillsPageService, times(1)).getAllSkills();
    }
}