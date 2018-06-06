package com.nike.oregon.spring.service;


import com.nike.oregon.spring.entity.WildLife;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by VRadh1 on 4/5/2017.
 */
@Service
public class WildLifeService {

    private static final Logger logger = LoggerFactory.getLogger(WildLifeService.class);

    @Async
    public List<WildLife> getwildLifes() {
        try {
            logger.info("getwildLifes start sleep {} ", Thread.currentThread());
            Thread.sleep(10000);
            logger.info("getwildLifes end sleep {} ", Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Async
    public List<WildLife> getwildLifesAsync() {
        logger.info("Invoking getwildLifesAsync for {} ", Thread.currentThread());
        String url = "http://environment.ehp.qld.gov.au/species/?op=getclassnames&kingdom=animals";
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        CompletableFuture<Future<ResponseEntity<String>>> completableFuture = CompletableFuture.supplyAsync(()-> {
            Future<ResponseEntity<String>> futureEntity = restTemplate.getForEntity(url, String.class);
            return futureEntity;
        });
        completableFuture.thenAcceptAsync(this::complete);
        try {
            Thread.sleep(10000);
            logger.info("After sleep for {} ", Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }


    private void complete(Future<ResponseEntity<String>> futureEntity) {
        logger.info("Completed for {} ", Thread.currentThread());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
