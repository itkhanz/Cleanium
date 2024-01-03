package com.itkhanz.designpatterns.strategy.initial.pages.components;

import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditCardComponent extends PaymentComponent{
  public CreditCardComponent(WebDriver dr) {
    super(dr);
  }

  private final By ccField = By.id("cc");
  private final By yearField = By.id("year");
  private final By cvvField = By.id("cvv");

  private void enterCC(String cc){
    driver.findElement(ccField).sendKeys(cc);
  }
  private void enterYear(String year){
    driver.findElement(yearField).sendKeys(year);
  }
  private void enterCVV(String cvv){
    driver.findElement(cvvField).sendKeys(cvv);
  }

  @Override
  public void fillPaymentInfo(PaymentInfo paymentInfo) {
    this.enterCC(paymentInfo.getCreditCardInfo().getCreditCard_CC());
    this.enterYear(paymentInfo.getCreditCardInfo().getCreditCard_year());
    this.enterCVV(paymentInfo.getCreditCardInfo().getCreditCard_CVV());
  }
}
