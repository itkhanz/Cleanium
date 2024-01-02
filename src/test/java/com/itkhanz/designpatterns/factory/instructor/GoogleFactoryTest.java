package com.itkhanz.designpatterns.factory.instructor;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.factory.instructor.factory.GooglePagesFactory;
import com.itkhanz.designpatterns.factory.instructor.pages.Google.GooglePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleFactoryTest extends BaseTest {
  private GooglePage googlePage;

  @Test(dataProvider = "getData")
  public void searchTest(String language, String keyword){
    this.googlePage = GooglePagesFactory.get(language, this.driver);
    this.googlePage.launchSite(); //hide away the logic to accept popup for cookies, and clicking language button
    this.googlePage.search(keyword);
    int resultCount = this.googlePage.getResultsCount();
    System.out.println("Result Count : " + resultCount);
  }

  @DataProvider
  public Object[][] getData(){
    return new Object[][]{
      {"ENG", "selenium"},
      {"FR", "design patterns"},
      {"ES", "selenium"}
    };
  }
}
