package com.toer.receiver.amqp;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.toer.receiver.db.Message;
import com.toer.receiver.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    MessageRepository repository;

    public void receiveMessage(String mess) {
        System.out.println("Received <" + mess + ">");
        latch.countDown();

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setTitle(mess);
        message.setBody(mess);
        message.setDate(new Date().toString());

        repository.save(message);

    }

    public void receiveMessage(byte[] message) {
        String str = new String(message, StandardCharsets.UTF_8);
        receiveMessage(str);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
