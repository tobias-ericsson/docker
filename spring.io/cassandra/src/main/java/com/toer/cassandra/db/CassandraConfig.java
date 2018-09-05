package com.toer.cassandra.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;

@Configuration
public class CassandraConfig {
    //@Value("${cassandra.contactpoints}") private String contactPoints;
    //@Value("${cassandra.port}") private int port;
    @Value("${cassandra.keyspace}") private String keyspace;
    //@Value("${cassandra.basepackages}") private String basePackages;
    protected String getKeyspaceName() {
        return keyspace;
    }
    /*
    @Override protected String getContactPoints() {
        return contactPoints;
    }
    @Override protected int getPort() {
        return port;
    }*/
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    /*@Override public String[] getEntityBasePackages() {
        return new String[] {
                basePackages
        };
    }*/
}
