package com.github.mbritzke.serviceapp.client;

import reactor.core.publisher.Flux;

public interface MerchantClient {

    Flux<MerchantClientResponse> getMerchants();
}
