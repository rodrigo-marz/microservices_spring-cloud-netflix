package com.roma.limitsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.roma.limitsservice.model.LimitsDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FaulToleranceController {
    
    @GetMapping("/exception-example")
    @HystrixCommand(fallbackMethod = "fallBackLimitsConfiguration")
    public LimitsDTO getLimitsConfigurationsReturnsAnException() {
    	throw new RuntimeException("Some fancy, complex and mysterious exception");
    }
    
    public LimitsDTO fallBackLimitsConfiguration() {
    	log.info("Retrieve info from FallBack method");
        return new LimitsDTO(0, 100);
    }
}
