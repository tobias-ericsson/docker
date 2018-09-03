package com.toer.receiver.amqp;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public void receiveMessage(byte[] message) {
        String str = new String(message, StandardCharsets.UTF_8);
        receiveMessage(str);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
