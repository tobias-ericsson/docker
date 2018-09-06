package com.toer.receiver.web;

import com.toer.receiver.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/")
public class WebController {

    @Autowired
    MessageRepository repository;

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return repository.findAll();
    }

}
