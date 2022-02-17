package com.github.mbritzke.serviceapp.repository;

import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MerchantRepository extends ReactiveCrudRepository<MerchantEntity, Long> {
}
