package com.kashkina.portfolio.dto.about;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateDTO {

    private String name;
    private String issuer;
    private Integer year;

}
