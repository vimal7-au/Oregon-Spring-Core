package com.nike.oregon.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nike.oregon.spring.entity.Cruise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by VRadh1 on 3/30/2017.
 */
@Service(value = "CruiseService")
public class CruiseService implements InitializingBean {
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


    @Async
    public CompletableFuture<List<Cruise>> getCruisesAsync() {
        logger.info("getCruisesAsync ===>   {} ", Thread.currentThread().getId());
        List<Cruise> cruiseList = new ArrayList<>();
        cruiseList.add(new Cruise("Cuise-ZR-7"));
        return CompletableFuture.completedFuture(cruiseList);
    }





    public CruiseService() {
        logger.info("Constructor called");
    }


    @PostConstruct
    public void afterConstruct() {
        logger.info("Post Construct called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet  called");
    }


}
