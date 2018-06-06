package com.nike.oregon.spring.service;

import com.nike.oregon.spring.resource.CruiseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class AwsService {

    @Resource(name = "awsProperties")
    private Map<String, String> awsProperties;

    private static final Logger logger = LoggerFactory.getLogger(AwsService.class);


    public void configure() {
        logger.info(" The region is ==>{}", awsProperties.get("region") );
    }

}
