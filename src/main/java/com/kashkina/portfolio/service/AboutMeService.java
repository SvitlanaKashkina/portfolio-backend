package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.about.AboutMeDTO;
import com.kashkina.portfolio.dto.about.AboutMeResponseDTO;
import com.kashkina.portfolio.dto.about.CertificateDTO;
import com.kashkina.portfolio.dto.projects.ProjectFotoDto;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.about.AboutMeRepository;
import com.kashkina.portfolio.repository.about.CertificateRepository;
import com.kashkina.portfolio.repository.fotos.ProjectFotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@RequiredArgsConstructor
public class AboutMeService {

    private static final Logger log = LoggerFactory.getLogger(AboutMeService.class);

    private final AboutMeRepository repository;
    private final ProjectFotoRepository projectFotoRepository;
    private final CertificateRepository certificateRepository;
    private static final List<Integer> ABOUT_PHOTO_IDS = List.of(31, 32, 33, 35);

    public AboutMeResponseDTO getAboutMeContent() {
        log.info("Fetching About Me sections from the database");

        List<AboutMeDTO> sections = repository.findAll().stream()
                .map(a -> new AboutMeDTO(
                        a.getSectionKey(),
                        a.getTitle(),
                        a.getContent()))
                .toList();

        log.debug("Found {} About Me sections", sections.size());

        if (sections.isEmpty()) {
            log.error("No About Me sections found");
            throw new DataNotFoundException("About Me sections not found");
        }

        log.info("Fetching certificates from database");
        List<CertificateDTO> certificates = certificateRepository.findAll().stream()
                .map(c -> new CertificateDTO(
                        c.getName(),
                        c.getIssuer(),
                        c.getYear()))
                .toList();
        log.debug("Found {} certificates", certificates.size());

        if (certificates.isEmpty()) {
            log.error("No certificates found");
            throw new DataNotFoundException("Certificates not found");
        }

        log.info("Fetching About Me photos from database");

        // IDs фотографий для About Me
        List<Integer> aboutPhotoIds = List.of(31, 32, 33, 35);

        List<ProjectFotoDto> photos = projectFotoRepository
                .findAllById(ABOUT_PHOTO_IDS)
                .stream()
                .sorted(Comparator.comparingInt(
                        p -> ABOUT_PHOTO_IDS.indexOf(p.getId())
                ))
                .map(p -> new ProjectFotoDto(
                        p.getId(),
                        p.getImageUrl(),
                        p.getAltText(),
                        p.getDisplayOrder()
                ))
                .toList();

        log.debug("Found {} About Me photos", photos.size());

        return AboutMeResponseDTO.builder()
                .sections(sections)
                .certificates(certificates)
                .photos(photos)
                .build();
    }
}
