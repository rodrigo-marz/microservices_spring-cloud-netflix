package com.roma.limitsservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("limits-service")
public class ConfigurationProps {
    private int minimun;
    private int maximun;
}