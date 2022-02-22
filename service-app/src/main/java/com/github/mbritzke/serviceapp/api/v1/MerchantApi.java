package com.github.mbritzke.serviceapp.api.v1;

import com.github.mbritzke.serviceapp.dto.MerchantDto;
import com.github.mbritzke.serviceapp.service.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/merchants")
public class MerchantApi {

    private final MerchantService service;

    public MerchantApi(MerchantService service) {
        this.service = service;
    }

    @GetMapping("/countries/{country}")
    public ResponseEntity<Flux<MerchantDto>> getMerchantsByCountry(@PathVariable("country") CountryEnum country) {
        return ResponseEntity.ok(service.getMerchantsByCountry(country));
    }
}
