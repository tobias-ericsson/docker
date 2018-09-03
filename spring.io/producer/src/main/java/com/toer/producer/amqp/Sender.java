package com.toer.producer.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("spring-boot-exchange")
    private String topicExchangeName;

    @Value("foo.bar.baz")
    private String routingKey;


    public void sendMessage(String message) {

        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);

    }



}