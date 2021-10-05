package com.roma.limitsservice.controllers;

import com.roma.limitsservice.configurations.ConfigurationProps;
import com.roma.limitsservice.model.LimitsDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

	private final Environment environment;
    private final ConfigurationProps configurationProps;

    @GetMapping("limits")
    public LimitsDTO getLimitsConfigurations() {
    	log.info("Active Profile: {}", (Object[])environment.getActiveProfiles());
        return new LimitsDTO(configurationProps.getMinimun(), configurationProps.getMaximun());
    }
}
