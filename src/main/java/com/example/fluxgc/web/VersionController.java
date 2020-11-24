package com.example.fluxgc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VersionController {

    @GetMapping("/")
    public Mono<String> getVersion() {
        return Mono.just("Version 0.1");
    }
}
