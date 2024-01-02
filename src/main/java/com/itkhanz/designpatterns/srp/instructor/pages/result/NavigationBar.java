package com.itkhanz.designpatterns.srp.instructor.pages.result;

import com.itkhanz.designpatterns.srp.instructor.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {
  @FindBy(id = "hdtb")
  private WebElement bar;

  @FindBy(linkText = "News")
  private WebElement news;

  public NavigationBar(WebDriver driver) {
    super(driver);
  }

  public void goToNews(){
    this.news.click();
  }

  @Override
  public boolean isDisplayed() {
    return this.wait.until((d) -> this.bar.isDisplayed());
  }
}
