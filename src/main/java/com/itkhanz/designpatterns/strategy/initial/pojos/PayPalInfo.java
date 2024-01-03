package com.itkhanz.designpatterns.strategy.initial.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PayPalInfo {
  private String paypal_username;
  private String paypal_password;
}
