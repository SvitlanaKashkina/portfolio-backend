package com.kashkina.portfolio.unit.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.kashkina.portfolio.kafka.producer.VisitEventProducer;
import com.kashkina.portfolio.service.HomeContentService;
import com.kashkina.portfolio.controller.HomeController;
import com.kashkina.portfolio.dto.home.HomeContentDTO;
import com.kashkina.portfolio.dto.projects.ProjectFotoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpSession;
import java.util.List;

class HomeContentControllerTest {

    private HomeController controller;
    private HomeContentService service;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        service = mock(HomeContentService.class); // mock service
        controller = new HomeController(service, mock(VisitEventProducer.class)); // controller with mock service
        session = mock(HttpSession.class); // mock session
    }

    @Test
    void testGetHomeContentDTO_Success() {
        // Prepare mock DTO
        ProjectFotoDto videoDto = new ProjectFotoDto(34, "https://example.com/video.mp4", "Home Video", 1);
        HomeContentDTO dto = new HomeContentDTO(
                "Alice Example",
                "Developer",
                "Frontend",
                "I build cool apps",
                "https://github.com/alice",
                "https://linkedin.com/in/alice",
                List.of(videoDto) // videos
        );

        // Mock service behavior
        when(service.getHomeContentDTO()).thenReturn(dto);

        // Call controller
        HomeContentDTO result = controller.getHomeContent((jakarta.servlet.http.HttpSession) session);

        // Assertions
        assertNotNull(result);
        assertEquals("Alice Example", result.getFullName());
        assertEquals("Developer", result.getRoleTitle());
        assertEquals("Frontend", result.getRoleType());
        assertEquals("I build cool apps", result.getShortBio());
        assertEquals("https://github.com/alice", result.getGithubUrl());
        assertEquals("https://linkedin.com/in/alice", result.getLinkedinUrl());

        // Check video
        assertNotNull(result.getVideos());
        assertEquals(1, result.getVideos().size());
        assertEquals(34, result.getVideos().get(0).id());
        assertEquals("https://example.com/video.mp4", result.getVideos().get(0).imageUrl());

        // Verify service call
        verify(service, times(1)).getHomeContentDTO();
    }

    @Test
    void testGetHomeContentDTO_ServiceThrowsException() {
        // Mock service throws exception
        when(service.getHomeContentDTO()).thenThrow(new RuntimeException("Home content not found"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> controller.getHomeContent((jakarta.servlet.http.HttpSession) session));

        assertEquals("Home content not found", exception.getMessage());

        verify(service, times(1)).getHomeContentDTO();
    }
}