package com.belrose.springbootmysqlk8s.service;

import com.belrose.springbootmysqlk8s.model.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
    double getAmount(String sourceCurrency, String targetCurrency);

    ExchangeRate addExchangeRate(ExchangeRate exchangeRate);
}
