package com.zara.pricing.application.service;

import com.zara.pricing.domain.model.Price;
import com.zara.pricing.domain.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceRepository.findApplicablePrice(productId, brandId, applicationDate);
    }
}
