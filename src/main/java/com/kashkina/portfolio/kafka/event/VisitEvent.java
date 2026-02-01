package com.kashkina.portfolio.kafka.event;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitEvent {
    private String sessionId;
    private String page;   // "/api/about", "/api/home" ....
    private LocalDateTime timestamp;
}
