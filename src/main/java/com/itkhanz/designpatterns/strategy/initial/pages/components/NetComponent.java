package com.itkhanz.designpatterns.strategy.initial.pages.components;

import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NetComponent extends PaymentComponent{
  public NetComponent(WebDriver dr) {
    super(dr);
  }

  private final By bankSelect = By.id("bank");
  private final By accountInput = By.id("acc_number");
  private final By pinInput = By.id("pin");

  private void enterAccount(String account) {
    driver.findElement(accountInput).sendKeys(account);
  }
  private void enterPin(String pin) {
    driver.findElement(pinInput).sendKeys(pin);
  }

  private void selectBank(String bank) {
    Select select = new Select(driver.findElement(bankSelect));
    select.selectByValue(bank);
  }


  @Override
  public void fillPaymentInfo(PaymentInfo paymentInfo) {
    this.selectBank(paymentInfo.getNetInfo().getNet_bank());
    this.enterAccount(paymentInfo.getNetInfo().getNet_account());
    this.enterPin(paymentInfo.getNetInfo().getNet_pin());
  }
}
