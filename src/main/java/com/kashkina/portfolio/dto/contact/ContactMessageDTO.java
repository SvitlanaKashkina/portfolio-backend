package com.kashkina.portfolio.dto.contact;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageDTO {
    private String name;
    private String email;
    private String subject;
    private String message;
    private String phone;
    private Boolean consent;
}
