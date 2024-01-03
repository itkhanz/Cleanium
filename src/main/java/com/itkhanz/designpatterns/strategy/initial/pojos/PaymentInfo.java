package com.itkhanz.designpatterns.strategy.initial.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
  private CreditCardInfo creditCardInfo;
  private NetInfo netInfo;
  private PayPalInfo payPalInfo;
}
