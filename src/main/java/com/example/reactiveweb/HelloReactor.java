package com.example.reactiveweb;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class HelloReactor {
    public static void main(String[] args) {
        Mono.just("Hello reactor")
            .subscribe(System.out::println);

        Flux<String> sequence = Flux.just("Hello", "just");
        sequence.map(String::toLowerCase)
            .subscribe(log::info);
    }
}
