package com.nike.oregon.spring.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * Created by VRadh1 on 3/27/2017.
 */
@Component
public class ServerHealthCheck extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder healthBuilder) throws Exception {
        boolean running = true;
        if (running) {
            healthBuilder.up();
        } else {
            healthBuilder.down();
        }
    }
}

