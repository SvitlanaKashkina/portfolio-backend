package com.kashkina.portfolio.unit.services;

import com.kashkina.portfolio.dto.contact.ContactMessageDTO;
import com.kashkina.portfolio.entity.contact.ContactMessage;
import com.kashkina.portfolio.repository.contact.ContactMessageRepository;
import com.kashkina.portfolio.service.ContactMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactMessageServiceTest {

    @Mock
    private ContactMessageRepository repository;

    @InjectMocks
    private ContactMessageService service;

    @Test
    void saveContactMessage_success() {
        // ===== Arrange =====
        ContactMessageDTO dto = ContactMessageDTO.builder()
                .name("Alice")
                .email("alice@test.com")
                .subject("Question")
                .message("Hello!")
                .phone("123456789")
                .consent(true)
                .build();

        ContactMessage savedEntity = ContactMessage.builder()
                .id(1L)
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .phone(dto.getPhone())
                .consent(true)
                .build();

        when(repository.save(any(ContactMessage.class)))
                .thenReturn(savedEntity);

        // ===== Act =====
        ContactMessage result = service.saveContactMessage(dto);

        // ===== Assert =====
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alice", result.getName());
        assertEquals("alice@test.com", result.getEmail());

        verify(repository, times(1)).save(any(ContactMessage.class));
    }

    @Test
    void saveContactMessage_consentMissing_throwsException() {
        // ===== Arrange =====
        ContactMessageDTO dto = ContactMessageDTO.builder()
                .name("Alice")
                .email("alice@test.com")
                .subject("Question")
                .message("Hello!")
                .consent(false)
                .build();

        // ===== Act & Assert =====
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.saveContactMessage(dto)
        );

        assertEquals("DSGVO consent is required", exception.getMessage());

        verify(repository, never()).save(any());
    }
}