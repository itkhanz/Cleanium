package com.itkhanz.designpatterns.srp.intial;

import com.itkhanz.designpatterns.srp.initial.base.PageFactory;
import com.itkhanz.designpatterns.srp.initial.pages.HomePage;
import com.itkhanz.designpatterns.srp.initial.pages.SearchResultsPage;
import com.itkhanz.designpatterns.srp.initial.pages.components.SearchSuggestionsComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class GoogleTest extends BaseTest{
  private HomePage homePage;
  private SearchSuggestionsComponent searchSuggestionsComponent;
  private SearchResultsPage searchResultsPage;

  @Test(dataProvider = "googleData")
  public void test_google_search_results(String searchText, int searchSuggestionsIndex) {
    homePage = PageFactory.createPage(HomePage.class);

    //open home page and accept cookies popup
    homePage.open("https://www.google.com").getCookiesPopup().accept();

    //enter the text into search field and choose search suggestion based on specified index
    searchSuggestionsComponent = homePage.getSearchbox().searchText(searchText);
    searchResultsPage = searchSuggestionsComponent.chooseSearchSuggestion(searchSuggestionsIndex);

    //repeat the previous process
    searchResultsPage.getSearchbox().searchText(searchText);
    searchSuggestionsComponent.chooseSearchSuggestion(searchSuggestionsIndex);

    //open the News menu in header navigation of search results
    searchResultsPage.getSearchHeaderPage().navigateToMenu("News");

    //print the stats
    System.out.println(searchResultsPage.getStatsText());

  }

  @DataProvider
  private static Object[][] googleData() {
    return new Object[][] {
      {"test automation", 3}
    };
  }
}
