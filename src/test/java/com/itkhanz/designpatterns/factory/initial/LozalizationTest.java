package com.itkhanz.designpatterns.factory.initial;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.factory.initial.pages.PageFactory;
import com.itkhanz.designpatterns.factory.initial.pages.home.HomePage;
import com.itkhanz.designpatterns.factory.initial.pages.results.ResultsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class LozalizationTest extends BaseTest {

  @Test(dataProvider = "getData")
  public void test_google_localization(String country, String resultText) {

    HomePage homePage = PageFactory.createHomePage(country, driver);

    homePage.open();
    homePage.acceptPopup();
    homePage.choosePageLanguage();
    homePage.searchText("berlin");

    ResultsPage resultsPage = homePage.chooseFirstSuggestion();

    Assertions.assertThat(resultsPage.getStats()).contains(resultText);
  }

  @DataProvider
  private Object[][] getData() {
    return new Object[][] {
      {"france", "résultats"},
      {"english", "results"}
    };
  }
}
