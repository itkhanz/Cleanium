package com.itkhanz.designpatterns.strategy.initial.pages;

import com.itkhanz.designpatterns.strategy.initial.enums.PaymentMethod;
import com.itkhanz.designpatterns.strategy.initial.pages.components.CreditCardComponent;
import com.itkhanz.designpatterns.strategy.initial.pages.components.NetComponent;
import com.itkhanz.designpatterns.strategy.initial.pages.components.PaypalComponent;
import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends AbstractPage{

  PaypalComponent paypalComponent;
  CreditCardComponent creditCardComponent;
  NetComponent netComponent;

  public OrderPage(WebDriver dr) {
    super(dr);
    this.creditCardComponent = new CreditCardComponent(dr);
    this.netComponent = new NetComponent(dr);
    this.paypalComponent = new PaypalComponent(dr);
  }

  private final By firstName = By.id("fn");
  private final By lastName = By.id("ln");
  private final By email = By.id("email");
  private final By buyBtn = By.id("buy");
  private final By orderID = By.id("ordernumber");

  public OrderPage open(){
    driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    return this;
  }

  private OrderPage fillFirstName(String fName) {
    driver.findElement(firstName).sendKeys(fName);
    return this;
  }

  private OrderPage filllastName(String lName) {
    driver.findElement(lastName).sendKeys(lName);
    return this;
  }

  private OrderPage fillEmail(String emailText) {
    driver.findElement(email).sendKeys(emailText);
    return this;
  }

  public OrderPage fillPersonalInfo(String fName, String lName, String email) {
    return fillFirstName(fName).filllastName(lName).fillEmail(email);
  }

  public OrderPage fillPaymentInfo(PaymentMethod paymentMethod, PaymentInfo paymentInfo) {
    switch (paymentMethod) {
      case CREDIT_CARD -> creditCardComponent.fillPaymentInfo(paymentInfo);
      case PAYPAL -> paypalComponent.fillPaymentInfo(paymentInfo);
      case NET_BANKING -> netComponent.fillPaymentInfo(paymentInfo);
      default -> throw new RuntimeException("Invalid payment method: " + paymentMethod.name());
    }
    return this;
  }

  public OrderPage placeOrder() {
    driver.findElement(buyBtn).click();
    return this;
  }

  public String getOrderID() {
    return driver.findElement(orderID).getText();
  }
}
