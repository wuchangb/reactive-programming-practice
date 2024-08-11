package com.example.reactiveweb;

import reactor.core.publisher.Mono;

public class HelloReactor {
    public static void main(String[] args) {
        Mono.just("Hello reactor")
            .subscribe(System.out::println);
    }
}
