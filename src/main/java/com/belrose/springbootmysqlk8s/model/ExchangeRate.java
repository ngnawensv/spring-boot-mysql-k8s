package com.belrose.springbootmysqlk8s.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "exchange-rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    private String sourceCurrency;
    private String targetCurrency;
    private double amount;
    private String lastUpdated;
}
