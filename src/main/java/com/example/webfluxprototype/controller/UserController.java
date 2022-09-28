package com.example.webfluxprototype.controller;

import com.example.webfluxprototype.dto.User;
import com.example.webfluxprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Mono<User> findUserById(@PathVariable String id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/all")
    public Flux<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @PostMapping("/save")
    public Mono<Void> saveUser(@RequestBody Mono<User> user) {
        return userRepository.saveUser(user).then();
    }


}
