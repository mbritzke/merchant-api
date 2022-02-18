package com.github.mbritzke.serviceapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.serviceapp.api.v1.CountryEnum;
import com.github.mbritzke.serviceapp.client.MerchantClient;
import com.github.mbritzke.serviceapp.client.MerchantClientResponse;
import com.github.mbritzke.serviceapp.dto.MerchantDto;
import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import com.github.mbritzke.serviceapp.repository.MerchantRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MerchantService {

    private final MerchantClient client;
    private final MerchantRepository repository;
    private final ObjectMapper objectMapper;

    public MerchantService(MerchantClient client, MerchantRepository repository, ObjectMapper objectMapper) {
        this.client = client;
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveMerchants() {
        Flux<MerchantClientResponse> merchants = client.getMerchants();
        merchants.map(this::convertToEntity).flatMap(repository::save).subscribe();
    }

    private MerchantEntity convertToEntity(MerchantClientResponse merchantClientResponse) {
        return objectMapper.convertValue(merchantClientResponse, MerchantEntity.class);
    }

    public Flux<MerchantDto> getMerchantsByCountry(CountryEnum country) {
        return repository.findAllByCountry(country.getCurrency()).map(this::convertToDto);
    }

    private MerchantDto convertToDto(MerchantEntity entity) {
        return objectMapper.convertValue(entity, MerchantDto.class);
    }
}
