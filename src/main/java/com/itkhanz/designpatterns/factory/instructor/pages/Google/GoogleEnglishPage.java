package com.itkhanz.designpatterns.factory.instructor.pages.Google;

import org.openqa.selenium.WebDriver;

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
