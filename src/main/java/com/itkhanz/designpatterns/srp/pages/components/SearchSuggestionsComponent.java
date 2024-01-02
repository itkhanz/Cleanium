package com.itkhanz.designpatterns.srp.pages.components;

import com.itkhanz.designpatterns.srp.base.PageFactory;
import com.itkhanz.designpatterns.srp.pages.BasePage;
import com.itkhanz.designpatterns.srp.pages.SearchResultsPage;
import org.openqa.selenium.By;

public class SearchSuggestionsComponent extends BasePage {
  private static final String searchSuggestedItem = "//*[@id='Alh6id']//li[%s]";

  public SearchResultsPage chooseSearchSuggestion(int searchSuggestionIndex) {
    By searchSuggestionItem = By.xpath(String.format(searchSuggestedItem, searchSuggestionIndex));
    click(searchSuggestionItem);
    return PageFactory.createPage(SearchResultsPage.class);
  }
}
