package com.toer.cassandra.amqp;

import com.toer.cassandra.db.Message;
import com.toer.cassandra.db.ReactiveMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    ReactiveMessageRepository repository;


     public void receiveMessage(String mess) {
       System.out.println("Received <" + mess + ">");
        latch.countDown();

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setTitle(mess);
        message.setBody(mess);
        message.setDate(new Date().toString());

        repository.save(message).subscribe(System.out::println);

    }

    public void receiveMessage(byte[] message) {
        String str = new String(message, StandardCharsets.UTF_8);
        receiveMessage(str);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
