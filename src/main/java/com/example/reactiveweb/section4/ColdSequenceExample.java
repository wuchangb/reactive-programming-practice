package com.example.reactiveweb.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
public class ColdSequenceExample {
    public static void main(String[] args) {
        Flux<Object> coldFlux = Flux.fromIterable(Arrays.asList("RED", "YELLOW", "PINK")).map(String::toLowerCase);

        coldFlux.subscribe(cold -> log.info("# Subscriber1: {}", cold));
        log.info("=============================");
        coldFlux.subscribe(cold -> log.info("# Subscriber2: {}", cold));
    }
}
