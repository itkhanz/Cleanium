package com.itkhanz.designpatterns.strategy.initial.factory;

import com.itkhanz.designpatterns.strategy.initial.enums.PaymentMethod;
import com.itkhanz.designpatterns.strategy.initial.pages.components.CreditCardComponent;
import com.itkhanz.designpatterns.strategy.initial.pages.components.NetComponent;
import com.itkhanz.designpatterns.strategy.initial.pages.components.PaymentComponent;
import com.itkhanz.designpatterns.strategy.initial.pages.components.PaypalComponent;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Function;
public class PaymentComponentFactory {
  private static final Function<WebDriver, PaymentComponent> payWithCreditCard = CreditCardComponent::new;
  private static final Function<WebDriver, PaymentComponent> payWithNetBanking = NetComponent::new;
  private static final Function<WebDriver, PaymentComponent> payWithPayPal = PaypalComponent::new;

  private static final HashMap<PaymentMethod, Function<WebDriver, PaymentComponent>> paymentComponentMap = new HashMap<>();
  static {
    paymentComponentMap.put(PaymentMethod.CREDIT_CARD, payWithCreditCard);
    paymentComponentMap.put(PaymentMethod.NET_BANKING, payWithNetBanking);
    paymentComponentMap.put(PaymentMethod.PAYPAL, payWithPayPal);
  }

  public static PaymentComponent getPaymentComponent(PaymentMethod paymentMethod, WebDriver driver) {
    return paymentComponentMap.get(paymentMethod).apply(driver);
  }
}
