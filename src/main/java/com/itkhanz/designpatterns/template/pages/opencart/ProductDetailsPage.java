package com.itkhanz.designpatterns.template.pages.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

  @FindBy(css = "div#content li h2")
  private WebElement price;

  public ProductDetailsPage(WebDriver driver) {
    super(driver);
  }

  public void buy() {
    this.wait.until((d) -> this.price.isDisplayed());
    System.out.println(
      this.price.getText()
    );
  }
}
