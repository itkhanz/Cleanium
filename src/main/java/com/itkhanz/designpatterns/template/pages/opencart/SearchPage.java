package com.itkhanz.designpatterns.template.pages.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

  @FindBy(css="div#search input")
  private WebElement searchBox;

  @FindBy(css="div#search button")
  private WebElement searchBtn;

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public void launchSite() {
    this.driver.get("https://naveenautomationlabs.com/opencart/index.php");
  }

  public void searchForProduct(String product) {
    this.searchBox.sendKeys(product);
    this.searchBtn.click();
  }
}
