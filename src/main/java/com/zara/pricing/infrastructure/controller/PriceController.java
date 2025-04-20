package com.zara.pricing.infrastructure.controller;

import com.zara.pricing.application.service.PriceService;
import com.zara.pricing.domain.model.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
@Tag(name = "Prices API", description = "Endpoints para consultar precios de productos")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(
        summary = "Obtener precio aplicable",
        description = "Consulta el precio aplicable en una fecha, para un producto y cadena."
    )
    @GetMapping
    public ResponseEntity<Price> getPrice(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId,
            @RequestParam("applicationDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Optional<Price> price = priceService.getApplicablePrice(productId, brandId, applicationDate);
        return price.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
