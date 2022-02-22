package com.github.mbritzke.serviceapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.serviceapp.client.MerchantClient;
import com.github.mbritzke.serviceapp.client.MerchantClientResponse;
import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import com.github.mbritzke.serviceapp.facade.LoadMerchantFacade;
import com.github.mbritzke.serviceapp.repository.MerchantRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class LoadMerchantService implements LoadMerchantFacade {

    private final MerchantClient client;
    private final MerchantRepository repository;
    private final ObjectMapper objectMapper;

    public LoadMerchantService(MerchantClient client, MerchantRepository repository, ObjectMapper objectMapper) {
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

}
