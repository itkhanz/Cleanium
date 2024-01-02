package com.itkhanz.designpatterns.factory.instructor.pages.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class GoogleESPage extends GooglePage{
  @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
  private WebElement language;

  public GoogleESPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void launchSite(){
    this.driver.get("https://www.google.es");
    this.cookieAlert.accept();
    this.language.click();
  }
}
