package com.roma.currencyconversionservice.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CurrencyConversionDTO {
    Long id;
    String source;
    String target;
    BigDecimal conversionRate;
    BigDecimal quantity;
    BigDecimal totalCalculatedAmount;
    @NonFinal @Setter String port;
}