package com.itkhanz.designpatterns.factory.instructor.pages.Google;

import com.google.common.util.concurrent.Uninterruptibles;
import com.itkhanz.designpatterns.factory.instructor.pages.AbstractPage;
import com.itkhanz.designpatterns.factory.instructor.pages.alerts.CookieAlert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class GooglePage extends AbstractPage {

  public abstract void launchSite();

  protected CookieAlert cookieAlert;

  public GooglePage(WebDriver dr) {
    super(dr);
    cookieAlert = new CookieAlert(dr);
  }

  @FindBy(name="q")
  private WebElement searchBox;

  @FindBy(name = "btnK")
  private WebElement searchBtn;

  @FindBy(css = "#rso div")
  private List<WebElement> results;


  public void search(String keyword) {
    for(char ch : keyword.toCharArray()){
      Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
      this.searchBox.sendKeys(ch + "");
    }
    this.wait.until((d) -> this.searchBtn.isDisplayed());
    this.searchBtn.click();
  }

  public int getResultsCount() {
    this.wait.until((d) -> this.results.size() > 1);
    return this.results.size();
  }
}
