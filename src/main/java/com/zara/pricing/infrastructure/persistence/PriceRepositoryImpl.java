package com.zara.pricing.infrastructure.persistence;

import com.zara.pricing.domain.model.Price;
import com.zara.pricing.domain.repository.PriceRepository;
import com.zara.pricing.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository jpaRepository;

    public PriceRepositoryImpl(PriceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return jpaRepository
                .findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        productId, brandId, applicationDate, applicationDate)
                .map(this::mapToDomain);
    }

    private Price mapToDomain(PriceEntity entity) {
        return new Price(
                entity.getProductId(),
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
        );
    }
}
