package com.itkhanz.designpatterns.strategy.initial.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardInfo {
  private String creditCard_CC;
  private String creditCard_year;
  private String creditCard_CVV;
}
