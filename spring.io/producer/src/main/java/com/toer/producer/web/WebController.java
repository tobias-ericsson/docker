package com.toer.producer.web;

import com.toer.producer.amqp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/")
public class WebController {

    @Autowired
    Sender sender;

    @RequestMapping(method=GET)
    public String root() {

        String pre = "<p><a href='";
        String post = "</p>";

        List<String> urls = new ArrayList<String>();
        urls.add("/send?message=test");
        urls.add("http://localhost:15672");

        String result = urls.stream().
                map(url -> pre+url+"'/>"+url+post).
                reduce("", (a,b) -> a + b);

        return "<body>"+result+"</body>";
    }

    @RequestMapping(method=GET, value = "send")
    public String producer(@RequestParam("message") String message) {

        sender.sendMessage(message);

        return "produced: "+message;
    }

}
