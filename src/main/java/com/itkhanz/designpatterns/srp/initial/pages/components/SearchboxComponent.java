package com.itkhanz.designpatterns.srp.initial.pages.components;

import com.itkhanz.designpatterns.srp.initial.base.PageFactory;
import com.itkhanz.designpatterns.srp.initial.pages.BasePage;
import org.openqa.selenium.By;

public class SearchboxComponent extends BasePage {
  private static final By searchField = By.xpath("//textarea[@name='q']");

  public SearchSuggestionsComponent searchText(String text) {
    click(searchField);
    clearAndType(searchField, text);
    return PageFactory.createPage(SearchSuggestionsComponent.class);
  }

}
