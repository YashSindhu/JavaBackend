package com.prac;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    @PostConstruct
    public void init() {
        System.out.println("Audit Service Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Audit Service Destroyed");
    }

    public void log(String message) {
        System.out.println("AUDIT LOG: " + message);
    }
}