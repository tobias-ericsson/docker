package com.toer.cassandra;

import com.toer.cassandra.db.Message;
import com.toer.cassandra.db.ReactiveMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class Application {

	@Autowired
	ReactiveMessageRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//@PostConstruct
	@EventListener(ApplicationReadyEvent.class)
	public void init() {

		Message message = new Message();
		message.setId(1L);
		message.setTitle("First message");
		message.setBody("First body");
		message.setDate(new Date().toString());

		repository.save(message).subscribe(System.out::println);
	}
}
