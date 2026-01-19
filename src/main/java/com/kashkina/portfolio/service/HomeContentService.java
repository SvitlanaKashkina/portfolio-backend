package com.kashkina.portfolio.service;

import com.kashkina.portfolio.dto.HomeContentDTO;
import com.kashkina.portfolio.entity.HomeContent;
import com.kashkina.portfolio.repository.HomeContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeContentService {

    private final HomeContentRepository homeContentRepository;

    public HomeContentDTO getHomeContentDTO() {
        HomeContent content = homeContentRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        if (content == null) return null;

        return HomeContentDTO.builder()
                .fullName(content.getFullName())
                .roleTitle(content.getRoleTitle())
                .roleType(content.getRoleType())
                .shortBio(content.getShortBio())
                .githubUrl(content.getGithubUrl())
                .linkedinUrl(content.getLinkedinUrl())
                .build();
    }
}

