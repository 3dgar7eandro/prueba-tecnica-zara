package com.zara.pricing.infrastructure.controller;

import com.zara.pricing.application.service.PriceService;
import com.zara.pricing.domain.model.Price;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<Price> getPrice(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId,
            @RequestParam("applicationDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Optional<Price> price = priceService.getApplicablePrice(productId, brandId, applicationDate);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
