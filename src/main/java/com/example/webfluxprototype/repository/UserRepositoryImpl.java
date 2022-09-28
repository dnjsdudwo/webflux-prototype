package com.example.webfluxprototype.repository;

import com.example.webfluxprototype.dto.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{
    Map<Integer, User> userMap = new HashMap<>();
    public UserRepositoryImpl() {
        userMap.put(1, User.builder().id("admin").birthDay(new Date()).address("Seoul").name("Jone").phone("31233-232").build());
        userMap.put(2, User.builder().id("user2").birthDay(new Date()).address("Pusan").name("James").phone("31773-232").build());
        userMap.put(3, User.builder().id("user3").birthDay(new Date()).address("Gangwondo").name("Mike").phone("314213-232").build());
        userMap.put(4, User.builder().id("user4").birthDay(new Date()).address("Hongkong").name("Jami").phone("31243-232").build());
        userMap.put(5, User.builder().id("user5").birthDay(new Date()).address("Jeunju").name("Hoper").phone("31253-232").build());
        userMap.put(6, User.builder().id("user6").birthDay(new Date()).address("Gyenggido").name("Tiny").phone("31263-232").build());
        userMap.put(7, User.builder().id("user7").birthDay(new Date()).address("Incheon").name("Tom").phone("31273-232").build());
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromStream(userMap.values().stream());
    }

    @Override
    public Mono<User> findUserById(String id) {
        User findUser = userMap.values()
                .stream().filter(v -> v.getId().equals(id))
                .findFirst().orElseGet(() -> null);


        return Mono.justOrEmpty(findUser);
    }

    @Override
    public Mono<Void> saveUser(Mono<User> user) {
        Mono<User> userMono = user.doOnNext(value-> {
            userMap.put((userMap.keySet().size() + 1), value);
        });

        return userMono.then();
    }
}
