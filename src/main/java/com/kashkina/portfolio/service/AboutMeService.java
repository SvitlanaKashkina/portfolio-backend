package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.AboutMeDTO;
import com.kashkina.portfolio.dto.AboutMeResponseDTO;
import com.kashkina.portfolio.dto.CertificateDTO;
import com.kashkina.portfolio.repository.AboutMeRepository;
import com.kashkina.portfolio.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutMeService {

    private final AboutMeRepository repository;
    private final CertificateRepository certificateRepository;

    public AboutMeResponseDTO getAboutMeContent() {
        List<AboutMeDTO> sections = repository.findAll().stream()
                .map(a -> new AboutMeDTO(a.getSectionKey(), a.getTitle(), a.getContent()))
                .collect(Collectors.toList());

        List<CertificateDTO> certificates = certificateRepository.findAll().stream()
                .map(c -> new CertificateDTO(c.getName(), c.getIssuer(), c.getYear()))
                .collect(Collectors.toList());

        return new AboutMeResponseDTO(sections, certificates);
    }

}
