package com.roma.currencyexchangeservice.repositories;

import java.util.Optional;

import com.roma.currencyexchangeservice.model.ExchangeValue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findBySourceAndTarget(String source, String target);
}
