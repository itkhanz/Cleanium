package com.itkhanz.designpatterns.strategy.initial.factory;

import com.itkhanz.designpatterns.strategy.initial.enums.PaymentMethod;
import com.itkhanz.designpatterns.strategy.initial.pojos.CreditCardInfo;
import com.itkhanz.designpatterns.strategy.initial.pojos.NetInfo;
import com.itkhanz.designpatterns.strategy.initial.pojos.PayPalInfo;
import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {

  private static Map<PaymentMethod, Supplier<PaymentInfo>> paymentMapper = new HashMap<>();

  static {
    paymentMapper.put(PaymentMethod.CREDIT_CARD, () -> PaymentInfo.builder().setCreditCardInfo(PaymentFactory.getCreditCardInfo()).build());
    paymentMapper.put(PaymentMethod.NET_BANKING, () -> PaymentInfo.builder().setNetInfo(PaymentFactory.getNetInfo()).build());
    paymentMapper.put(PaymentMethod.PAYPAL, () -> PaymentInfo.builder().setPayPalInfo(PaymentFactory.getPayPalInfo()).build());
  }
  public static PaymentInfo getPaymentInfo(PaymentMethod paymentMethod) {
    return paymentMapper.get(paymentMethod).get();
  }

  private static PayPalInfo getPayPalInfo() {
    return PayPalInfo.builder().setPaypal_username("test").setPaypal_password("123").build();
  }

  private static NetInfo getNetInfo() {
    return NetInfo.builder().setNet_account("dewsd4563d4e").setNet_bank("BOFA").setNet_pin("12345").build();
  }

  private static CreditCardInfo getCreditCardInfo() {
    return CreditCardInfo.builder().setCreditCard_CC("abc").setCreditCard_year("2024").setCreditCard_CVV("123").build();
  }
}
