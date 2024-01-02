package com.itkhanz.designpatterns.factory.instructor.pages.Google;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleEnglishPage extends GooglePage{

  public GoogleEnglishPage(final WebDriver driver){
    super(driver);
  }

  @Override
  public void launchSite() {
    this.driver.get("https://www.google.com");
    this.cookieAlert.accept();
  }

}
