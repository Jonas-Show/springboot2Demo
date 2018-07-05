package com.udian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/6/22.
 */
@RestController
public class WebFluxController {
    @GetMapping("/hello")
    public Mono<String> hello(){
        return Mono.just("hello webflux");
    }
}
