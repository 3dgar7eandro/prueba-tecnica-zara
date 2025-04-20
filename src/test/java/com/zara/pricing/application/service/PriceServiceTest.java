package com.zara.pricing.application.service;

import com.zara.pricing.domain.model.Price;
import com.zara.pricing.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PriceServiceTest {

    private PriceRepository priceRepository;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        priceRepository = mock(PriceRepository.class);
        priceService = new PriceService(priceRepository);
    }

    @Test
    void shouldReturnApplicablePrice() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price expectedPrice = new Price(
                productId,
                brandId,
                LocalDateTime.of(2020, 6, 14, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59),
                1,
                0,
                35.50,
                "EUR"
        );

        when(priceRepository.findApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> result = priceService.getApplicablePrice(productId, brandId, applicationDate);

        assertEquals(expectedPrice, result.orElse(null));
        verify(priceRepository, times(1)).findApplicablePrice(productId, brandId, applicationDate);
    }
}
