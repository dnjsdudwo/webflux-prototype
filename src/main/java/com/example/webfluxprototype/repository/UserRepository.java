package com.example.webfluxprototype.repository;

import com.example.webfluxprototype.dto.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Flux<User> getAllUsers();
    Mono<User> findUserById(String id);
    Mono<Void> saveUser(Mono<User> user);
}
