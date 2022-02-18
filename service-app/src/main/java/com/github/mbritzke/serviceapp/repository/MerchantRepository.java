package com.github.mbritzke.serviceapp.repository;

import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MerchantRepository extends ReactiveCrudRepository<MerchantEntity, Long> {

    Flux<MerchantEntity> findAllByCountry(String country);
}
