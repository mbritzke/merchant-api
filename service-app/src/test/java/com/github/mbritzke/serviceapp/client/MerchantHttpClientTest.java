package com.github.mbritzke.serviceapp.client;

import com.github.mbritzke.serviceapp.configuration.WebClientConfiguration;
import com.github.mbritzke.serviceapp.exception.MerchantErrorException;
import com.github.mbritzke.serviceapp.stub.MerchantClientDtoStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebClientConfiguration.class)
class MerchantHttpClientTest {

    @Autowired
    private WebClient webClient;

    @Test
    void getMerchantsShouldReturnSucess() {
        String url = "https://app.guusto.io/api/merchant/merchant/findAllWithoutLimit";
        MerchantClient client = new MerchantHttpClient(url, webClient);

        Flux<MerchantClientResponse> actual = client.getMerchants();
        StepVerifier.create(actual).assertNext(
                merchant -> {
                    Assertions.assertThat(merchant).usingRecursiveComparison().isEqualTo(MerchantClientDtoStub.create());
                }).verifyComplete();
    }

    @Test
    void getMerchantsShouldThrowException() {
        String url = "https://app.guusto.io/api/merchant/merchant/findError";
        MerchantClient client = new MerchantHttpClient(url, webClient);

        Flux<MerchantClientResponse> actual = client.getMerchants();
        StepVerifier.create(actual).expectErrorSatisfies(
                error -> Assertions.assertThat(error).isExactlyInstanceOf(MerchantErrorException.class)
        ).verify();
    }
}