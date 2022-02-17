package com.github.mbritzke.serviceapp.api.v1;

import com.github.mbritzke.serviceapp.dto.MerchantDto;
import com.github.mbritzke.serviceapp.service.MerchantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MerchantApi {

    private final MerchantService service;

    public MerchantApi(MerchantService service) {
        this.service = service;
    }

    @GetMapping("/{country}")
    public ResponseEntity<Flux<MerchantDto>> getMerchantsByCountry(@PathVariable("country") CountryEnum country) {
        if (country != null)
            return ResponseEntity.ok(service.getMerchantsByCountry(country));
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
