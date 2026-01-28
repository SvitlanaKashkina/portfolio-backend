package com.kashkina.portfolio.unit.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.kashkina.portfolio.dto.home.HomeContentDTO;
import com.kashkina.portfolio.entity.home.HomeContent;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.home.HomeContentRepository;
import com.kashkina.portfolio.service.HomeContentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class HomeContentServiceTest {

    @Mock
    private HomeContentRepository homeContentRepository;

    @InjectMocks
    private HomeContentService homeContentService;

    @Test
    void getHomeContentDTO_success() {
        // ===== Arrange =====
        HomeContent content = new HomeContent();
        content.setFullName("Alice");
        content.setRoleTitle("Developer");
        content.setRoleType("Full-stack");
        content.setShortBio("Short bio about Alice");
        content.setGithubUrl("https://github.com/alice");
        content.setLinkedinUrl("https://linkedin.com/in/alice");

        when(homeContentRepository.findAll()).thenReturn(List.of(content));

        // ===== Act =====
        HomeContentDTO dto = homeContentService.getHomeContentDTO();

        // ===== Assert =====
        assertNotNull(dto);
        assertEquals("Alice", dto.getFullName());
        assertEquals("Developer", dto.getRoleTitle());
        assertEquals("Full-stack", dto.getRoleType());
        assertEquals("Short bio about Alice", dto.getShortBio());
        assertEquals("https://github.com/alice", dto.getGithubUrl());
        assertEquals("https://linkedin.com/in/alice", dto.getLinkedinUrl());

        verify(homeContentRepository, times(1)).findAll();
    }

    @Test
    void getHomeContentDTO_noContent_throwsException() {
        // ===== Arrange =====
        when(homeContentRepository.findAll()).thenReturn(List.of());

        // ===== Act & Assert =====
        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> homeContentService.getHomeContentDTO()
        );

        assertEquals("Home content not found in database", exception.getMessage());

        verify(homeContentRepository, times(1)).findAll();
    }
}