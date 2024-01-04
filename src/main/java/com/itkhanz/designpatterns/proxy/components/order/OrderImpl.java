package com.itkhanz.designpatterns.proxy.components.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderImpl implements Order{

  @FindBy(id = "buy")
  private WebElement buyNow;

  @FindBy(id = "ordernumber")
  private WebElement orderNumber;

  public OrderImpl(final WebDriver driver){
    PageFactory.initElements(driver, this);
  }

  @Override
  public String placeOrder() {
    this.buyNow.click();
    return this.orderNumber.getText();
  }
}
