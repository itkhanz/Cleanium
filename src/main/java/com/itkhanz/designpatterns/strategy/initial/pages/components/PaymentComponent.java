package com.itkhanz.designpatterns.strategy.initial.pages.components;

import com.itkhanz.designpatterns.strategy.initial.pages.AbstractPage;
import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.openqa.selenium.WebDriver;

public abstract class PaymentComponent extends AbstractPage {
  public PaymentComponent(WebDriver dr) {
    super(dr);
  }

  public abstract void fillPaymentInfo(PaymentInfo paymentInfo);
}
