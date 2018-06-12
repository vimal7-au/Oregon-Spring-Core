package com.nike.oregon.spring.actuators;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "server")
public class ServerEndpoint {

    @ReadOperation
    public List<String> invokeGet() {
        List<String> serverDetails = new ArrayList<String>();
        try {
            serverDetails.add("Server IP Address : " + InetAddress.getLocalHost().getHostAddress());
            serverDetails.add("Server OS : " + System.getProperty("os.name").toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverDetails;
    }

}