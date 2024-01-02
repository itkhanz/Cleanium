package com.itkhanz.designpatterns.factory.initial.pages.results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishResultsPage extends ResultsPage{
  private static final By stats = By.xpath("//*[@id='result-stats']");

  public EnglishResultsPage(WebDriver dr) {
    super(dr);
  }

  @Override
  public String getStats() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(stats)).getText();
  }
}
