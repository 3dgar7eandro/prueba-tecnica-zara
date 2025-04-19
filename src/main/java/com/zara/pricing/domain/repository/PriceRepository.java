package com.zara.pricing.domain.repository;

import com.zara.pricing.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
