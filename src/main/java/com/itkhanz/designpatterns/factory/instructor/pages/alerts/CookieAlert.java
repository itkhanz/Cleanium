package com.itkhanz.designpatterns.factory.instructor.pages.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieAlert extends AbstractAlert {
  public CookieAlert(WebDriver driver) {
    super(driver);
  }

  private By acceptBtn = By.xpath("//button//*[text()='Accept all' or text()='Alle akzeptieren']");

  @Override
  public void accept() {
    driver.findElement(acceptBtn).click();
  }


}
