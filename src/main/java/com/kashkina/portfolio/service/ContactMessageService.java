package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.contact.ContactMessageDTO;
import com.kashkina.portfolio.entity.contact.ContactMessage;
import com.kashkina.portfolio.repository.contact.ContactMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public ContactMessage saveContactMessage(ContactMessageDTO dto) {
        // Можно добавить здесь проверку consent и валидацию
        if (dto.getConsent() == null || !dto.getConsent()) {
            throw new IllegalArgumentException("DSGVO consent is required");
        }

        ContactMessage message = ContactMessage.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .phone(dto.getPhone())
                .consent(dto.getConsent())
                .build();

        return repository.save(message);
    }
}
