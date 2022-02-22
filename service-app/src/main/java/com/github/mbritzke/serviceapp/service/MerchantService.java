package com.github.mbritzke.serviceapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.serviceapp.api.v1.CountryEnum;
import com.github.mbritzke.serviceapp.dto.MerchantDto;
import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import com.github.mbritzke.serviceapp.facade.MerchantFacade;
import com.github.mbritzke.serviceapp.repository.MerchantRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MerchantService implements MerchantFacade {

    private final MerchantRepository repository;
    private final ObjectMapper objectMapper;

    public MerchantService(MerchantRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Flux<MerchantDto> getMerchantsByCountry(CountryEnum country) {
        return repository.findAllByCountry(country.getCurrency()).map(this::convertToDto);
    }

    private MerchantDto convertToDto(MerchantEntity entity) {
        return objectMapper.convertValue(entity, MerchantDto.class);
    }
}
