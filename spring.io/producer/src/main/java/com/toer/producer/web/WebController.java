package com.toer.producer.web;

import com.toer.producer.amqp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/")
public class WebController {

    @Autowired
    Sender sender;

    @RequestMapping(method = GET)
    public String root() {

        String pre = "<p><a href='";
        String post = "</p>";

        Map<String, String> urls = new HashMap<>();

        urls.put("/send?message=test", "send");
        urls.put("http://localhost:8081", "receiver");
        urls.put("http://localhost:8082", "cassandra");
        urls.put("http://localhost:8090", "adminer");
        urls.put("http://localhost:8091", "cadviser");
        urls.put("http://localhost:8092", "cassandra-web");
        urls.put("http://localhost:15672", "rabbitMQ");

        String result = urls.entrySet().stream().
                map(url -> pre + url.getKey() + "'/>" + url.getValue() + post).
                reduce("", (a, b) -> a + b);

        return "<body>" + result + "</body>";
    }

    @RequestMapping(method = GET, value = "send")
    public String producer(@RequestParam("message") String message) {

        sender.sendMessage(message);

        return "produced: " + message;
    }

}
