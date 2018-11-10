package com.nike.oregon.spring.resource;

import com.nike.oregon.spring.configuration.EnvConfig;
import com.nike.oregon.spring.entity.WildLife;
import com.nike.oregon.spring.service.WildLifeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by VRadh1 on 4/5/2017.
 */
@RestController
@RequestMapping(value = "/v1/nike", produces = {APPLICATION_JSON_VALUE})
public class WildLifeResource {

    private static final Logger logger = LoggerFactory.getLogger(WildLifeResource.class);

    @Autowired
    WildLifeService wildLifeService;

    @Autowired
    EnvConfig envConfig;


    @RequestMapping(value = "/wildlifes", method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WildLife>> getWildLifes() {
        logger.info("Start getWildLifes");
        wildLifeService.getwildLifes();
        logger.info("End getWildLifes");

        logger.info("Version value is ==========>" + envConfig.getVersion());

        return new ResponseEntity(Collections.EMPTY_LIST, HttpStatus.OK);
    }


    @RequestMapping(value = "/wildlifesAsync", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<List<WildLife>> executeSlowTask() {
        wildLifeService.getwildLifesAsync();
        return new ResponseEntity(Collections.EMPTY_LIST, HttpStatus.OK);
    }

}
