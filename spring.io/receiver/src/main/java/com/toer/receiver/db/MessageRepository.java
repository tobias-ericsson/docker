package com.toer.receiver.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MessageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "select * from messages";
    final String INSERT_QUERY = "insert into messages (title, body, date) values (?, ?)";

    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.queryForList(SQL);

    }

    public int save(Message message) {
        return jdbcTemplate.update(INSERT_QUERY,
                message.getTitle(),
                message.getBody(),
                message.getDate());
    }
}
