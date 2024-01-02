package com.itkhanz.designpatterns.factory.initial.pages.home;

import com.itkhanz.designpatterns.factory.initial.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends AbstractPage {
  public abstract void choosePageLanguage();

  public abstract void open();
  public abstract <T extends AbstractPage> T chooseFirstSuggestion();

  private By searchField = By.xpath("//textarea[@name='q']");
  private By acceptBtn = By.xpath("//button//*[text()='Accept all' or text()='Alle akzeptieren']");
  protected By firstSuggestion = By.xpath("//*[@id='Alh6id']//li[1]");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void acceptPopup() {
    driver.findElement(acceptBtn).click();
  }

  public void searchText(String text) {
    driver.findElement(searchField).click();
    driver.findElement(searchField).clear();
    driver.findElement(searchField).sendKeys(text);
  }

}
