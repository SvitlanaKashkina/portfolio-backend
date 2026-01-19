package com.kashkina.portfolio.dto;

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
