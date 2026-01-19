package com.kashkina.portfolio.dto;

import lombok.*;

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
}
