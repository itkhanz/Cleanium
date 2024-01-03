package com.itkhanz.designpatterns.command;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.command.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends BaseTest {
  private HomePage homePage;

  @BeforeMethod
  public void setHomePage(){
    this.homePage = new HomePage(driver);
  }

  @Test
  public void homePageTest(){
    SoftAssert softAssert = new SoftAssert();

    this.homePage.goTo();
    this.homePage.getElementValidators()
      .stream()
      .parallel()
      .forEach(elementValidator -> {
        softAssert.assertTrue(elementValidator.validate(), elementValidator.getMessage());
      });

    softAssert.assertAll();
  }
}
