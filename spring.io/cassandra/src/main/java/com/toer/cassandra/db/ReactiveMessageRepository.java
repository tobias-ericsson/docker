package com.toer.cassandra.db;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveMessageRepository extends ReactiveCassandraRepository<Message, Long> {


    @Query("SELECT * FROM message WHERE title = ?0")
    Mono<Message> findByTitle(String title);

    Flux<Message> findByDate(Mono<String> date);
}
