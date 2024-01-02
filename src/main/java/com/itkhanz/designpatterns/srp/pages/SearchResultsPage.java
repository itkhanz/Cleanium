package com.itkhanz.designpatterns.srp.pages;

import com.itkhanz.designpatterns.srp.base.PageFactory;
import com.itkhanz.designpatterns.srp.pages.components.SearchHeaderComponent;
import com.itkhanz.designpatterns.srp.pages.components.SearchSuggestionsComponent;
import com.itkhanz.designpatterns.srp.pages.components.SearchboxComponent;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage{
  private static final By stats = By.xpath("//*[@id='result-stats']");

  private SearchboxComponent searchbox;
  private SearchSuggestionsComponent searchSuggestionsComponent;
  private SearchHeaderComponent searchHeaderComponent;

  public SearchResultsPage() {
    this.searchbox = PageFactory.createPage(SearchboxComponent.class);
    this.searchSuggestionsComponent = PageFactory.createPage(SearchSuggestionsComponent.class);
    this.searchHeaderComponent = PageFactory.createPage(SearchHeaderComponent.class);
  }

  public SearchboxComponent getSearchbox() {
    return searchbox;
  }
  public SearchSuggestionsComponent getSearchSuggestionsPage() {
    return searchSuggestionsComponent;
  }
  public SearchHeaderComponent getSearchHeaderPage() {
    return searchHeaderComponent;
  }

  public String getStatsText() {
    return getText(stats);
  }
}
