package com.itkhanz.designpatterns.srp.instructor.pages.result;

import com.itkhanz.designpatterns.srp.instructor.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultStat extends AbstractComponent {
  @FindBy(id = "result-stats")
  private WebElement stat;

  public ResultStat(WebDriver driver) {
    super(driver);
  }

  public String getStat(){
    return this.stat.getText();
  }

  @Override
  public boolean isDisplayed() {
    //return wait.until(ExpectedConditions.visibilityOf(this.stat)).isDisplayed();
    return this.wait.until((d) -> this.stat.isDisplayed());
  }
}
