package com.github.mbritzke.serviceapp.client;

import com.github.mbritzke.serviceapp.exception.MerchantErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MerchantHttpClient implements MerchantClient {

    private final String baseUrl;
    private final WebClient client;

    public MerchantHttpClient(@Value("${internal.base.url}") String baseUrl,
                              WebClient webClient) {
        this.baseUrl = baseUrl;
        this.client = webClient;
    }

    public Flux<MerchantClientResponse> getMerchants() {
        return client.get()
                .uri(getBaseUrl().toUriString())
                .retrieve()
                .onStatus(HttpStatus::isError, this::functionMerchantsHasError)
                .bodyToFlux(MerchantClientResponse.class);
    }

    private UriComponentsBuilder getBaseUrl() {
        return UriComponentsBuilder.fromUriString(baseUrl);
    }

    private Mono<MerchantErrorException> functionMerchantsHasError(ClientResponse response) {
        return Mono.error(new MerchantErrorException());
    }

}
