package com.itkhanz.designpatterns.srp.instructor.pages.main;

import com.itkhanz.designpatterns.srp.instructor.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesPopup extends AbstractComponent {

  @FindBy(id = "S3BnEe")
  WebElement cookiesHeading;

  @FindBy(xpath = "//button//*[text()='Accept all' or text()='Alle akzeptieren']")
  WebElement acceptBtn;

  @FindBy(xpath = "//button//*[text()='Reject all' or text()='Alle ablehnen']")
  WebElement rejectBtn;

  public CookiesPopup(WebDriver driver) {
    super(driver);
  }

  @Override
  public boolean isDisplayed() {
    return this.wait.until((d) -> this.cookiesHeading.isDisplayed());
  }

  public void acceptCookies() {
    this.acceptBtn.click();
  }

  public void rejectCookies() {
    this.rejectBtn.click();
  }
}
