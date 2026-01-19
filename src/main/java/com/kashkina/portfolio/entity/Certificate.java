package com.kashkina.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "certificates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "year")
    private Integer year;

    @Column(name = "display_order")
    private Integer displayOrder;
}
