package com.example.reactiveweb.section3;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


/**
 * Mono
 * - 1개의 데이터를 생성해서 emit 한다.
 */
@Slf4j
public class MonoExample {
    public static void main(String[] args) {
        Mono.just("Hello Reactor")
            .subscribe(data -> log.info("# emitted data: {}", data));
    }
}
