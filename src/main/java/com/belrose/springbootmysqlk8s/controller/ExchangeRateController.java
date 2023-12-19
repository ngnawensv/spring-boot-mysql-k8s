package com.belrose.springbootmysqlk8s.controller;

import com.belrose.springbootmysqlk8s.model.ExchangeRate;
import com.belrose.springbootmysqlk8s.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/getAmount")
    public double getAmount(@RequestParam String sourceCurrency,@RequestParam String targetCurrency){
        return exchangeRateService.getAmount(sourceCurrency,targetCurrency);
    }

    @PostMapping("/addExchangeRate")
    public ExchangeRate addExchangeRate(@RequestBody ExchangeRate exchangeRate){
        return exchangeRateService.addExchangeRate(exchangeRate);
    }
}
