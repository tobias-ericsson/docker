package com.toer.producer.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MyMySQLHealthIndicator implements HealthIndicator {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "select * from test";

    @Override
    public Health health() {
        int errorCode = 0; // perform some specific health check
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
        } catch (Exception e) {
            errorCode = -1;
        }

        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}
