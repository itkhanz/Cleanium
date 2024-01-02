package com.itkhanz.designpatterns.srp.instructor.pages.result;

import com.itkhanz.designpatterns.srp.instructor.pages.common.SearchSuggestion;
import com.itkhanz.designpatterns.srp.instructor.pages.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
  private SearchWidget searchWidget;
  private SearchSuggestion searchSuggestion;
  private NavigationBar navigationBar;
  private ResultStat resultStat;

  public ResultPage(final WebDriver driver){
    this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
    this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
    this.resultStat = PageFactory.initElements(driver, ResultStat.class);
  }

  public SearchWidget getSearchWidget() {
    return searchWidget;
  }

  public SearchSuggestion getSearchSuggestion() {
    return searchSuggestion;
  }

  public NavigationBar getNavigationBar() {
    return navigationBar;
  }

  public ResultStat getResultStat() {
    return resultStat;
  }
}
