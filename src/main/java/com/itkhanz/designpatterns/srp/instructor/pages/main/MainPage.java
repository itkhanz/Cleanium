package com.itkhanz.designpatterns.srp.instructor.pages.main;

import com.itkhanz.designpatterns.srp.instructor.pages.common.SearchSuggestion;
import com.itkhanz.designpatterns.srp.instructor.pages.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
  private WebDriver driver;
  private SearchWidget searchWidget;
  private SearchSuggestion searchSuggestion;
  private CookiesPopup cookiesPopup;

  public MainPage(final WebDriver driver){
    this.driver = driver;
    this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
    this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    this.cookiesPopup = PageFactory.initElements(driver, CookiesPopup.class);
  }

  public void goTo(){
    this.driver.get("https://www.google.com");
  }

  public SearchWidget getSearchWidget() {
    return searchWidget;
  }

  public SearchSuggestion getSearchSuggestion() {
    return searchSuggestion;
  }

  public CookiesPopup getCookiesPopup() {
    return cookiesPopup;
  }

}
