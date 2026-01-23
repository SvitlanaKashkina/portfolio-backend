package com.kashkina.portfolio.dto.about;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutMeDTO {

    private String sectionKey;
    private String title;
    private String content;
}