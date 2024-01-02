package com.itkhanz.designpatterns.srp.pages.components;

import com.itkhanz.designpatterns.srp.base.PageFactory;
import com.itkhanz.designpatterns.srp.pages.BasePage;
import com.itkhanz.designpatterns.srp.pages.SearchResultsPage;
import org.openqa.selenium.By;

public class SearchHeaderComponent extends BasePage {
  private static final String headerMenuItemStr = "//*[@id='bqHHPb']//*[text()='%s']";

  public SearchResultsPage navigateToMenu(String menu) {
    By headerItem = By.xpath(String.format(headerMenuItemStr, menu));
    click(headerItem);
    return PageFactory.createPage(SearchResultsPage.class);
  }

}
