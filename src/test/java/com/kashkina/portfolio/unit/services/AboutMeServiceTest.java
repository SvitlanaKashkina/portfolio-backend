package com.kashkina.portfolio.unit.services;

import com.kashkina.portfolio.dto.about.AboutMeResponseDTO;
import com.kashkina.portfolio.entity.about.AboutMe;
import com.kashkina.portfolio.entity.about.Certificate;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.about.AboutMeRepository;
import com.kashkina.portfolio.repository.about.CertificateRepository;
import com.kashkina.portfolio.service.AboutMeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AboutMeServiceTest {

    @Mock
    private AboutMeRepository aboutMeRepository;

    @Mock
    private CertificateRepository certificateRepository;

    @InjectMocks
    private AboutMeService aboutMeService;

    @Test
    void getAboutMeContent_success() {
        // given
        AboutMe aboutMe = new AboutMe();
        aboutMe.setSectionKey("experience");
        aboutMe.setTitle("Experience");
        aboutMe.setContent("5 years in Java");

        Certificate certificate = new Certificate();
        certificate.setName("Java SE");
        certificate.setIssuer("Oracle");
        certificate.setYear(2023);

        when(aboutMeRepository.findAll()).thenReturn(List.of(aboutMe));
        when(certificateRepository.findAll()).thenReturn(List.of(certificate));

        // when
        AboutMeResponseDTO result = aboutMeService.getAboutMeContent();

        // then
        assertNotNull(result);
        assertEquals(1, result.getSections().size());
        assertEquals(1, result.getCertificates().size());

        verify(aboutMeRepository).findAll();
        verify(certificateRepository).findAll();
    }

    @Test
    void getAboutMeContent_noSections_throwsException() {
        // given
        when(aboutMeRepository.findAll()).thenReturn(List.of());

        // when + then
        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> aboutMeService.getAboutMeContent()
        );

        assertEquals("About Me sections not found", exception.getMessage());

        verify(aboutMeRepository).findAll();
        verifyNoInteractions(certificateRepository);
    }

    @Test
    void getAboutMeContent_noCertificates_throwsException() {
        // given
        AboutMe aboutMe = new AboutMe();
        aboutMe.setSectionKey("bio");
        aboutMe.setTitle("Bio");
        aboutMe.setContent("Short bio");

        when(aboutMeRepository.findAll()).thenReturn(List.of(aboutMe));
        when(certificateRepository.findAll()).thenReturn(List.of());

        // when + then
        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class,
                () -> aboutMeService.getAboutMeContent()
        );

        assertEquals("Certificates not found", exception.getMessage());

        verify(aboutMeRepository).findAll();
        verify(certificateRepository).findAll();
    }
}