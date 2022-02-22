package com.github.mbritzke.serviceapp.api.v1;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

@RestController
public class GreetApi {

    @GetMapping("/")
    public Mono<String> greet(Mono<Principal> principal, ServerWebExchange serverWebExchange) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.FOUND);
        serverWebExchange.getResponse().getHeaders().put(HttpHeaders.LOCATION, List.of("/swagger-ui/"));
        return Mono.empty();
    }

}