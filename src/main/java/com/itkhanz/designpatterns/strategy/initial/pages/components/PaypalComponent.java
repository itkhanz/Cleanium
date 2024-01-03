package com.itkhanz.designpatterns.strategy.initial.pages.components;

import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaypalComponent extends PaymentComponent{
  public PaypalComponent(WebDriver dr) {
    super(dr);
  }

  private final By userName = By.id("paypal_username");
  private final By password = By.id("paypal_password");

  private void enterUserName(String name) {
    driver.findElement(userName).sendKeys(name);
  }
  private void enterPassword(String pwd) {
    driver.findElement(password).sendKeys(pwd);
  }

  @Override
  public void fillPaymentInfo(PaymentInfo paymentInfo) {
    this.enterUserName(paymentInfo.getPayPalInfo().getPaypal_username());
    this.enterPassword(paymentInfo.getPayPalInfo().getPaypal_password());
  }




}
