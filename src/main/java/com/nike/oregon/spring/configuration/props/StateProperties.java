package com.nike.oregon.spring.configuration.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@ConfigurationProperties(prefix = "usa")
public class StateProperties {
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    List<State> states;
}
