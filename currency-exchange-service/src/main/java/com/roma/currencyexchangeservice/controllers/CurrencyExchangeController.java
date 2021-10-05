package com.roma.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import com.roma.currencyexchangeservice.model.ExchangeValue;
import com.roma.currencyexchangeservice.repositories.ExchangeValueRepository;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository repository;

    @GetMapping("/exchange/from/{source}/to/{target}")
    public ExchangeValue getExchangeValue(@PathVariable String source, @PathVariable String target) {
        var port = environment.getProperty("local.server.port");
        
        var exchangeValue = repository.findBySourceAndTarget(source, target)
            .orElse(new ExchangeValue(-1L, source, target, BigDecimal.ZERO));
        exchangeValue.setPort(port);

        return exchangeValue;
    }
}