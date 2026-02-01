package com.kashkina.portfolio.dto.about;

import com.kashkina.portfolio.dto.projects.ProjectFotoDto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutMeResponseDTO {
    private List<AboutMeDTO> sections;
    private List<CertificateDTO> certificates;
    private List<ProjectFotoDto> photos;
}
