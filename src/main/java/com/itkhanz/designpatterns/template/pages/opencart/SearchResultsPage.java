package com.itkhanz.designpatterns.template.pages.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

  @FindBy(css = "div.product-layout div.caption a")
  private List<WebElement> items;

  public SearchResultsPage(WebDriver driver) {
    super(driver);
  }

  public void selectProduct() {
    items.stream().findFirst().ifPresent(WebElement::click);
  }
}
