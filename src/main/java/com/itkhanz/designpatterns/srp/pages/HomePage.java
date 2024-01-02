package com.itkhanz.designpatterns.srp.pages;

import com.itkhanz.designpatterns.srp.base.PageFactory;
import com.itkhanz.designpatterns.srp.pages.components.SearchSuggestionsComponent;
import com.itkhanz.designpatterns.srp.pages.components.SearchboxComponent;
import com.itkhanz.designpatterns.srp.pages.popups.CookiesPopup;

public class HomePage extends BasePage {
  private CookiesPopup cookiesPopup;
  private SearchboxComponent searchboxComponent;
  private SearchSuggestionsComponent searchSuggestionsComponent;

  public HomePage() {
    this.cookiesPopup = PageFactory.createPage(CookiesPopup.class);
    this.searchboxComponent = PageFactory.createPage(SearchboxComponent.class);
    this.searchSuggestionsComponent = PageFactory.createPage(SearchSuggestionsComponent.class);
  }

  public HomePage open(String url) {
    load(url);
    return this;
  }

  public CookiesPopup getCookiesPopup() {
    return cookiesPopup;
  }
  public SearchboxComponent getSearchbox() {
    return searchboxComponent;
  }
  public SearchSuggestionsComponent getSearchSuggestionsPage() {
    return searchSuggestionsComponent;
  }

}
