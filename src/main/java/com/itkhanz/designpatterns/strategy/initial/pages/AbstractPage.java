package com.itkhanz.designpatterns.strategy.initial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public AbstractPage(WebDriver dr) {
    this.driver = dr;
    this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
  }
}
