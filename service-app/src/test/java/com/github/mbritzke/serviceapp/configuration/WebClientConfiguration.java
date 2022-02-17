package com.github.mbritzke.serviceapp.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mbritzke.serviceapp.stub.MerchantClientResponseStub;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@TestConfiguration
public class WebClientConfiguration {

    private static final String MERCHANTS_URL = "https://app.guusto.io/api/merchant/merchant/findAllWithoutLimit";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public WebClient webClient() {
        return WebClient.builder().exchangeFunction(
                request -> {
                    if (!request.method().matches(HttpMethod.GET.name())) {
                        return error("Wrong Method");
                    }
                    if (request.url().toString().startsWith(MERCHANTS_URL) && request.url().toString()
                            .contains("/api/merchant/merchant/findAllWithoutLimit")) {
                        return success();

                    }
                    return error("Wrong URL");
                }
        ).build();
    }

    private Mono<ClientResponse> error(final String message) {
        return Mono.fromCallable(
                () ->
                        ClientResponse.create(HttpStatus.INTERNAL_SERVER_ERROR)
                                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .body(message)
                                .build());
    }

    private Mono<ClientResponse> success() {
        return Mono.fromCallable(
                () ->
                        ClientResponse.create(HttpStatus.OK)
                                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .body(objectMapper.writeValueAsString(List.of(MerchantClientResponseStub.create())))
                                .build());
    }
}
