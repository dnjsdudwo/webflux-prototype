package com.example.webfluxprototype;

import com.example.webfluxprototype.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;

@SpringBootApplication
public class WebfluxPrototypeApplication {
    private static WebClient webClient = WebClient.create("http://localhost:8080");

    public static void main(String[] args) {

        SpringApplication.run(WebfluxPrototypeApplication.class, args);

        Mono<User> user =
                Mono.just(User.builder()
                        .id("user17")
                        .phone("13213-222")
                        .address("Jejudo")
                        .birthDay(new Date())
                        .name("Tim").build());

        user.subscribe(System.out::println);
        Mono<Void> result =
                webClient.post()
                .uri("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user, User.class)
                .retrieve()
                .bodyToMono(Void.class);

        result.subscribe();

    }


}
