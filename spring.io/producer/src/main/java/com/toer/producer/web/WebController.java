package com.toer.producer.web;

import com.toer.producer.amqp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/send")
public class WebController {

    @Autowired
    Sender sender;

    @RequestMapping(method=GET)
    public String producer(@RequestParam("message") String message) {

        sender.sendMessage(message);

        return "produced: "+message;
    }

}
