package com.nike.oregon.spring.service;


import com.nike.oregon.spring.configuration.props.StateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service(value = "FlightService")
@EnableConfigurationProperties(StateProperties.class)
public class FlightServiceImpl implements FlightService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StateProperties stateProperties;

    @Override
    public void invoke() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(stateProperties.getStates().get(0).getTrain(), String.class);
        System.out.println(forEntity);
    }
}
