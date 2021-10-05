package com.roma.currencyconversionservice.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.roma.currencyconversionservice.model.CurrencyConversionDTO;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/exchange/from/{source}/to/{target}")
	CurrencyConversionDTO getExchangeValue(
			@PathVariable("source") String source, @PathVariable("target") String target);
}
