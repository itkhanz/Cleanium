package com.itkhanz.designpatterns.factory.initial.pages.results;

import com.itkhanz.designpatterns.factory.initial.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ResultsPage extends AbstractPage {
  public ResultsPage(WebDriver dr) {
    super(dr);
  }

  public abstract String getStats();
}
