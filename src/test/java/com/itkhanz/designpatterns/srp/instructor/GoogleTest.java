package com.itkhanz.designpatterns.srp.instructor;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.srp.instructor.pages.main.MainPage;
import com.itkhanz.designpatterns.srp.instructor.pages.result.ResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
  private MainPage googleMainPage;
  private ResultPage googleResultPage;

  @BeforeMethod
  public void setupPages(){
    this.googleMainPage = new MainPage(driver);
    this.googleResultPage = new ResultPage(driver);
  }

  @Test(dataProvider = "getData")
  public void googleWorkflow(String keyword, int index){

    //String keyword = "selenium webdriver";
    //int index  = 3;

    googleMainPage.goTo();
    googleMainPage.getCookiesPopup().acceptCookies();
    Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

    googleMainPage.getSearchWidget().enter(keyword);
    Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

    googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
    Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

    googleResultPage.getSearchWidget().enter(keyword);
    Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

    googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

    googleResultPage.getNavigationBar().goToNews();

    System.out.println(
      googleResultPage.getResultStat().getStat()
    );

  }

  @DataProvider
  public Object[][] getData(){

    return new Object[][]{
      {"berlin", 3},
      {"docker", 2}
    };


  }
}
