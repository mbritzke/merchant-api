package com.github.mbritzke.serviceapp.facade;

import com.github.mbritzke.serviceapp.api.v1.CountryEnum;
import com.github.mbritzke.serviceapp.dto.MerchantDto;
import reactor.core.publisher.Flux;

public interface MerchantFacade {

    Flux<MerchantDto> getMerchantsByCountry(CountryEnum country);
}
