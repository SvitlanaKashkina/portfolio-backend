package com.kashkina.portfolio.dto.home;

import com.kashkina.portfolio.dto.projects.ProjectFotoDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeContentDTO {

    private String fullName;

    private String roleTitle;

    private String roleType;

    private String shortBio;

    private String githubUrl;

    private String linkedinUrl;

    private List<ProjectFotoDto> videos;
}
