package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.home.HomeContentDTO;
import com.kashkina.portfolio.dto.projects.ProjectFotoDto;
import com.kashkina.portfolio.entity.home.HomeContent;
import com.kashkina.portfolio.entity.projects.ProjectFoto;
import com.kashkina.portfolio.exception.DataNotFoundException;
import com.kashkina.portfolio.repository.fotos.ProjectFotoRepository;
import com.kashkina.portfolio.repository.home.HomeContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Service
@RequiredArgsConstructor
public class HomeContentService {

    private static final Logger log = LoggerFactory.getLogger(HomeContentService.class);

    private final HomeContentRepository homeContentRepository;
    private final ProjectFotoRepository mediaRepo;

    public HomeContentDTO getHomeContentDTO() {
        log.info("Fetching Home content from database");

        HomeContent content = homeContentRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Home content not found in database");
                    return new DataNotFoundException("Home content not found in database");
                });

        log.debug("Home content found: {}", content);

        // get the video
        ProjectFoto videoEntity = mediaRepo.findById(34)
                .orElseThrow(() -> {
                    log.error("Video with ID 34 not found");
                    return new DataNotFoundException("Video with ID 34 not found");
                });

        ProjectFotoDto videoDto = new ProjectFotoDto(
                videoEntity.getId(),
                videoEntity.getImageUrl(),
                videoEntity.getAltText(),
                videoEntity.getDisplayOrder()
        );

        // Creating a DTO for Home
        HomeContentDTO dto = new HomeContentDTO(
                content.getFullName(),
                content.getRoleTitle(),
                content.getRoleType(),
                content.getShortBio(),
                content.getGithubUrl(),
                content.getLinkedinUrl(),
                List.of(videoDto)
        );

        log.info("Returning HomeContentDTO successfully");
        log.debug("HomeContentDTO: {}", dto);

        return dto;
    }
}


