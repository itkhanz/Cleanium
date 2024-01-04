package com.itkhanz.designpatterns.proxy.components.payment;

import java.util.Map;

public interface PaymentOption {
  void enterPaymentInformation(Map<String, String> paymentDetails);
}
