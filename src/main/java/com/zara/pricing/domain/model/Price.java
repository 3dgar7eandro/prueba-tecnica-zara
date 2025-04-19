package com.zara.pricing.domain.model;

import java.time.LocalDateTime;

public record Price(
        Long productId,
        Long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer priceList,
        Integer priority,
        Double price,
        String currency
) {}
