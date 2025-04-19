package com.zara.pricing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices") // 👈 OBLIGATORIO para que data.sql funcione
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity {

    @Id
    private Long id;

    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;
}
