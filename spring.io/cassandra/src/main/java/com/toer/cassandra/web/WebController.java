package com.toer.cassandra.web;

import com.toer.cassandra.db.Message;
import com.toer.cassandra.db.ReactiveMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/")
public class WebController {

    @Autowired
    ReactiveMessageRepository repository;

    @GetMapping
    public Flux<Message> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Message> getById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
