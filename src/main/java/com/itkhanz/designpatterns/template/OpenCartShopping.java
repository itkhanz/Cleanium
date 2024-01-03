package com.itkhanz.designpatterns.template;

import com.itkhanz.designpatterns.template.pages.opencart.ProductDetailsPage;
import com.itkhanz.designpatterns.template.pages.opencart.SearchPage;
import com.itkhanz.designpatterns.template.pages.opencart.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenCartShopping extends ShoppingTemplate{

  private WebDriver driver;
  private String product;

  private SearchPage searchPage;
  private SearchResultsPage searchResultsPage;
  private ProductDetailsPage productDetailsPage;

  public OpenCartShopping(WebDriver driver, String product) {
    this.driver = driver;
    this.product = product;
    this.searchPage = PageFactory.initElements(driver, SearchPage.class);
    this.searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    this.productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
  }

  @Override
  public void launchSite() {
    this.searchPage.launchSite();
  }

  @Override
  public void searchForProduct() {
    this.searchPage.searchForProduct(product);
  }

  @Override
  public void selectProduct() {
    this.searchResultsPage.selectProduct();
  }

  @Override
  public void buy() {
    this.productDetailsPage.buy();
  }
}
