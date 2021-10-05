package com.roma.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ExchangeValue {

    @Id
    Long id;
    String source;
    String target;
    BigDecimal conversionRate;
    @Transient
    String port;

    public ExchangeValue(Long id, String source, String target, BigDecimal conversionRate) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.conversionRate = conversionRate;
    }
}