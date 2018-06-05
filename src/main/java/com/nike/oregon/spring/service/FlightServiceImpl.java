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
        String url = "http://api.bart.gov/api/route.aspx?cmd=routes&key=MW9S-E7SL-26DU-VV8V&json=y";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity);
    }
}
