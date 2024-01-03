package com.itkhanz.designpatterns.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class EBayShopping extends ShoppingTemplate {

  private WebDriver driver;
  private WebDriverWait wait;
  private String product;

  @FindBy(id="gh-ac")
  private WebElement searchBox;

  @FindBy(id="gh-btn")
  private WebElement searchBtn;

  @FindBy(css = "ul.srp-results li div.s-item__title")
  private WebElement item;

  @FindBy(css = "div.main-container div.x-price-primary")
  private WebElement price;

  public EBayShopping(WebDriver driver, String product){
    this.driver = driver;
    this.product = product;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  @Override
  public void launchSite() {
    this.driver.get("https://www.ebay.com/");
  }

  @Override
  public void searchForProduct() {
    this.searchBox.sendKeys(this.product);
    this.searchBtn.click();
  }

  @Override
  public void selectProduct() {
    this.wait.until((d) -> this.item.isDisplayed());
    this.item.click();

    //switch to new tab (product detail page opens in new tab)
    //Wait for the new window or tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }

  @Override
  public void buy() {
    this.wait.until((d) -> this.price.isDisplayed());
    System.out.println(
      this.price.getText()
    );
  }
}