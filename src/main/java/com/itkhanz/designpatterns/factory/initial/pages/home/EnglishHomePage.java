package com.itkhanz.designpatterns.factory.initial.pages.home;

import com.itkhanz.designpatterns.factory.initial.pages.AbstractPage;
import com.itkhanz.designpatterns.factory.initial.pages.results.EnglishResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishHomePage extends HomePage {
  By languageLocator = By.linkText("English");

  public EnglishHomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void choosePageLanguage() {
    driver.findElement(languageLocator).click();
  }

  @Override
  public void open() {
    driver.get("https://www.google.com");
  }

  @Override
  public <T extends AbstractPage> T chooseFirstSuggestion() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(firstSuggestion)).click();
    return (T) new EnglishResultsPage(driver);
  }
}
