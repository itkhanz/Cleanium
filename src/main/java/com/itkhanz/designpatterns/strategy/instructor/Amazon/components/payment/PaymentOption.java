package com.itkhanz.designpatterns.strategy.instructor.Amazon.components.payment;

import java.util.Map;

public interface PaymentOption {
  void enterPaymentInformation(Map<String, String> paymentDetails);
}
