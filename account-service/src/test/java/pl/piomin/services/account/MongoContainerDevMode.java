package pl.piomin.services.account;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration
public class MongoContainerDevMode {

    @Bean
    @ServiceConnection
    public MongoDBContainer mongo() {
        return new MongoDBContainer("mongo:5.0");
    }

}
