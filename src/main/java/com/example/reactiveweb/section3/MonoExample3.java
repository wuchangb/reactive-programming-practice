package com.example.reactiveweb.section3;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

/**
 * Mono 활용
 * - worldtimeapi.org Open api 이용해 서울의 현재 시간 조회하기
 */
@Slf4j
public class MonoExample3 {
    public static void main(String[] args) {
        URI worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
            .host("worldtimeapi.org")
            .port(80)
            .path("/api/timezone/Asia/Seoul")
            .build()
            .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono.just(
                restTemplate.exchange(worldTimeUri, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class)
            )
            .map(response -> {
                DocumentContext jsonContext = JsonPath.parse(response.getBody());
                String dateTime = jsonContext.read("$.datetime");
                return dateTime;
            })
            .subscribe(
                data -> log.info("# emitted data: " + data),
                error -> {
                    log.error(error.getMessage());
                },
                () -> log.info("# emitted onComplete signal")
            );
    }
}
