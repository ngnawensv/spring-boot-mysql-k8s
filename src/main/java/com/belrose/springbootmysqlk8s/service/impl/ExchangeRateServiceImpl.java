package com.belrose.springbootmysqlk8s.service.impl;

import com.belrose.springbootmysqlk8s.model.ExchangeRate;
import com.belrose.springbootmysqlk8s.repository.ExchangeRateRepository;
import com.belrose.springbootmysqlk8s.service.ExchangeRateService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }


    @Override
    public ExchangeRate findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency) {
        return exchangeRateRepository.findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);
    }

    @Override
    public double getAmount(String sourceCurrency, String targetCurrency) {
        ExchangeRate exchangeRate = findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);
        return exchangeRate==null?0:exchangeRate.getAmount();
    }

    @Override
    public ExchangeRate addExchangeRate(ExchangeRate exchangeRate) {
        exchangeRate.setLastUpdated(OffsetDateTime.now().toString());
        return exchangeRateRepository.save(exchangeRate);
    }
}
