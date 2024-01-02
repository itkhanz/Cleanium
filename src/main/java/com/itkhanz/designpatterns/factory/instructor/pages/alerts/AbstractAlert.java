package com.itkhanz.designpatterns.factory.instructor.pages.alerts;

import com.itkhanz.designpatterns.factory.instructor.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractAlert extends AbstractPage {
  public AbstractAlert(WebDriver driver) {
    super(driver);
  }

  public abstract void accept();
}
