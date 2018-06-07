package com.nike.oregon.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nike.oregon.spring.entity.Cruise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by VRadh1 on 3/30/2017.
 */
@Service
public class CruiseService {
    private static final Logger logger = LoggerFactory.getLogger(CruiseService.class);


    @HystrixCommand(fallbackMethod = "defaultCall")
    public List<Cruise> getCruises(String country) {
       // throw new RuntimeException();
        logger.info("The thread serving getCruises {}", Thread.currentThread().getName());
        return Collections.EMPTY_LIST;
    }

    public List<Cruise> defaultCall(String country) {
        logger.info("Default call");
        return Collections.EMPTY_LIST;
    }
}
