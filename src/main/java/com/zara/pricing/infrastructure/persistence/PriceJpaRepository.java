package com.zara.pricing.infrastructure.persistence;

import com.zara.pricing.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    Optional<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long productId,
            Long brandId,
            LocalDateTime applicationDate1,
            LocalDateTime applicationDate2
    );
}
