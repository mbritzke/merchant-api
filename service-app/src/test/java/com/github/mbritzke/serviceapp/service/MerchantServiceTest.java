package com.github.mbritzke.serviceapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.serviceapp.api.v1.CountryEnum;
import com.github.mbritzke.serviceapp.client.MerchantClient;
import com.github.mbritzke.serviceapp.dto.MerchantDto;
import com.github.mbritzke.serviceapp.entity.MerchantEntity;
import com.github.mbritzke.serviceapp.repository.MerchantRepository;
import com.github.mbritzke.serviceapp.stub.MerchantDtoStub;
import com.github.mbritzke.serviceapp.stub.MerchantEntityStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {

    @Mock
    private MerchantClient client;
    @Mock
    private MerchantRepository repository;
    @Spy
    private ObjectMapper objectMapper;
    @InjectMocks
    private MerchantService service;

    @Test
    void getMerchantsByCountryShouldReturnSuccess() {
        Mockito.when(repository.findAllByCountry("usd")).thenReturn(Flux.just(MerchantEntityStub.create()));
        Flux<MerchantDto> actual = service.getMerchantsByCountry(CountryEnum.USA);
        StepVerifier.create(actual).assertNext(
                merchant -> {
                    Assertions.assertThat(merchant).usingRecursiveComparison().isEqualTo(MerchantDtoStub.create());
                }
        ).verifyComplete();
    }
}