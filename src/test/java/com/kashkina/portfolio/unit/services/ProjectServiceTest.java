package com.kashkina.portfolio.unit.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.kashkina.portfolio.dto.projects.ProjectDto;
import com.kashkina.portfolio.entity.projects.Project;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.projects.ProjectRepository;
import com.kashkina.portfolio.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void getAllProjects_success() {
        // ===== Arrange =====
        Project project = new Project();
        project.setId(1L);
        project.setTitle("Project 1");
        project.setShortDescription("Short desc");
        project.setFullDescription("Full desc");
        project.setArchitectureDescription("Architecture");
        project.setRoleDescription("Role");
        project.setLessonsLearned("Lessons");
        project.setStatus("Completed");
        project.setEndDate(LocalDate.of(2024,1,1));
        project.setGithubUrl("https://github.com/project1");

        // empty Set for collections
        project.setTechnologies(Set.of());
        project.setFeatures(Set.of());
        project.setScreenshots(Set.of());

        when(projectRepository.findAll()).thenReturn(List.of(project));

        // ===== Act =====
        List<ProjectDto> dtos = projectService.getAllProjects();

        // ===== Assert =====
        assertNotNull(dtos);
        assertEquals(1, dtos.size());
        ProjectDto dto = dtos.get(0);
        assertEquals("Project 1", dto.getTitle());
        assertEquals("Short desc", dto.getShortDescription());
        assertEquals("Full desc", dto.getFullDescription());
        assertEquals("Architecture", dto.getArchitectureDescription());
        assertEquals("Role", dto.getRoleDescription());
        assertEquals("Lessons", dto.getLessonsLearned());
        assertEquals("Completed", dto.getStatus());
        assertEquals(LocalDate.of(2024,1,1), dto.getEndDate());
        assertEquals("https://github.com/project1", dto.getGithubUrl());

        // Checking the repository call
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void getAllProjects_emptyList_throwsException() {
        when(projectRepository.findAll()).thenReturn(List.of());

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> projectService.getAllProjects()
        );

        assertEquals("No projects found in the database", exception.getMessage());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void getAllProjects_missingRequiredFields_throwsException() {
        Project project = new Project();
        project.setId(1L);
        project.setTitle(null); // missing
        project.setShortDescription("Short desc");
        project.setFullDescription("Full desc");

        when(projectRepository.findAll()).thenReturn(List.of(project));

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> projectService.getAllProjects()
        );

        assertTrue(exception.getMessage().contains("Project with id 1 has missing required fields"));
        verify(projectRepository, times(1)).findAll();
    }
}
