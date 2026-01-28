package com.kashkina.portfolio.unit.services;

import com.kashkina.portfolio.dto.skills.SkillsPageDTO;
import com.kashkina.portfolio.entity.skills.SoftSkill;
import com.kashkina.portfolio.entity.skills.TechStackCategory;
import com.kashkina.portfolio.entity.skills.TechnicalSkillCategory;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.skills.*;
import com.kashkina.portfolio.service.SkillsPageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SkillsPageServiceTest {

    @Mock
    private SoftSkillRepository softSkillRepo;

    @Mock
    private TechStackCategoryRepository techStackCatRepo;

    @Mock
    private TechStackItemRepository techStackItemRepo;

    @Mock
    private TechnicalSkillCategoryRepository techCatRepo;

    @Mock
    private TechnicalSkillItemRepository techItemRepo;

    @InjectMocks
    private SkillsPageService skillsPageService;

    @Test
    void getAllSkills_success() {
        // ===== Arrange =====
        // Tech Stack
        TechStackCategory category = new TechStackCategory();
        category.setId(1L);
        category.setName("Frontend");
        category.setOrderIndex(1);

        when(techStackCatRepo.findAll()).thenReturn(List.of(category));
        when(techStackItemRepo.findByCategoryIdOrderByOrderIndexAsc(1L)).thenReturn(List.of());

        // Technical Skills
        TechnicalSkillCategory techCat = new TechnicalSkillCategory();
        techCat.setId(1L);
        techCat.setName("Programming");
        techCat.setOrderIndex(1);
        when(techCatRepo.findAll()).thenReturn(List.of(techCat));
        when(techItemRepo.findByCategoryIdOrderByOrderIndexAsc(1L)).thenReturn(List.of());

        // Soft Skills
        SoftSkill softSkill = new SoftSkill();
        softSkill.setId(1L);
        softSkill.setName("Communication");
        softSkill.setOrderIndex(1);
        when(softSkillRepo.findAll()).thenReturn(List.of(softSkill));

        // ===== Act =====
        SkillsPageDTO dto = skillsPageService.getAllSkills();

        // ===== Assert =====
        assertNotNull(dto);
        assertEquals(1, dto.getTechStack().size());
        assertEquals("Frontend", dto.getTechStack().get(0).getName());
        assertEquals(1, dto.getTechnicalSkills().size());
        assertEquals("Programming", dto.getTechnicalSkills().get(0).getName());
        assertEquals(1, dto.getSoftSkills().size());
        assertEquals("Communication", dto.getSoftSkills().get(0).getName());

        // Checking repository calls
        verify(techStackCatRepo, times(1)).findAll();
        verify(techStackItemRepo, times(1)).findByCategoryIdOrderByOrderIndexAsc(1L);
        verify(techCatRepo, times(1)).findAll();
        verify(techItemRepo, times(1)).findByCategoryIdOrderByOrderIndexAsc(1L);
        verify(softSkillRepo, times(1)).findAll();
    }

    @Test
    void getAllSkills_emptyTechStack_throwsException() {
        when(techStackCatRepo.findAll()).thenReturn(List.of());

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> skillsPageService.getAllSkills()
        );

        assertEquals("Tech stack categories not found", exception.getMessage());
        verify(techStackCatRepo, times(1)).findAll();
        verifyNoInteractions(techStackItemRepo, techCatRepo, techItemRepo, softSkillRepo);
    }

    @Test
    void getAllSkills_emptyTechnicalSkills_throwsException() {
        TechStackCategory category = new TechStackCategory();
        category.setId(1L);
        category.setName("Frontend");
        category.setOrderIndex(1);
        when(techStackCatRepo.findAll()).thenReturn(List.of(category));
        when(techStackItemRepo.findByCategoryIdOrderByOrderIndexAsc(1L)).thenReturn(List.of());

        when(techCatRepo.findAll()).thenReturn(List.of());

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> skillsPageService.getAllSkills()
        );

        assertEquals("Technical skill categories not found", exception.getMessage());
    }

    @Test
    void getAllSkills_emptySoftSkills_throwsException() {
        TechStackCategory category = new TechStackCategory();
        category.setId(1L);
        category.setName("Frontend");
        category.setOrderIndex(1);
        when(techStackCatRepo.findAll()).thenReturn(List.of(category));
        when(techStackItemRepo.findByCategoryIdOrderByOrderIndexAsc(1L)).thenReturn(List.of());

        TechnicalSkillCategory techCat = new TechnicalSkillCategory();
        techCat.setId(1L);
        techCat.setName("Programming");
        techCat.setOrderIndex(1);
        when(techCatRepo.findAll()).thenReturn(List.of(techCat));
        when(techItemRepo.findByCategoryIdOrderByOrderIndexAsc(1L)).thenReturn(List.of());

        when(softSkillRepo.findAll()).thenReturn(List.of());

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> skillsPageService.getAllSkills()
        );

        assertEquals("Soft skills not found", exception.getMessage());
    }
}