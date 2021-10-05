package com.roma.currencyconversionservice.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roma.currencyconversionservice.model.CurrencyConversionDTO;
import com.roma.currencyconversionservice.services.CurrencyExchangeServiceProxy;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy currencyExchangeProxy;
    
    @GetMapping(value="/currency-converter/from/{source}/to/{target}/quantity/{quantity}")
    public CurrencyConversionDTO getCurrencyConversion(@PathVariable String source,
        @PathVariable String target, @PathVariable BigDecimal quantity) {
        
		/*
		 * var uriVariables = new HashMap<String, String>(); uriVariables.put("source",
		 * source); uriVariables.put("target", target);
		 * 
		 * ResponseEntity<CurrencyConversionDTO> currencyExchange = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8000/currency-exchange/from/{source}/to/{target}",
		 * CurrencyConversionDTO.class, uriVariables); CurrencyConversionDTO response =
		 * currencyExchange.getBody();
		 */

    	CurrencyConversionDTO response = 
    			currencyExchangeProxy.getExchangeValue(source, target);
        
    	var result = CurrencyConversionDTO.builder().id(response.getId()).source(source)
        		.target(target).conversionRate(response.getConversionRate())
        		.quantity(quantity).totalCalculatedAmount(quantity.multiply(response.getConversionRate()))
        		.build();
    
        result.setPort(response.getPort());
        return result;
    }
    
}