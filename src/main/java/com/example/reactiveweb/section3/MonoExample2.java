package com.example.reactiveweb.section3;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Mono 예제 2
 * - 원본 데이터의 emit 없이 onComplete signal 만 emit 한다.
 */
@Slf4j
public class MonoExample2 {
    public static void main(String[] args) {
        Mono.empty()
            .subscribe(
                data -> log.info("# emitted data: {}", data),
                error -> {},
                () -> log.info("# emitted onComplete signal")
            );
    }
}
