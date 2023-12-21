package com.itkhanz.demos.part08.usecase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Consumer;

class SelectDemo {
  WebDriver driver;

  @BeforeTest
  private void setup() {
    driver = new ChromeDriver();
    driver.get("https://demoqa.com/select-menu");
  }

  @AfterTest
  private void teardown() {
    if (driver!= null) {
      driver.quit();
    }
  }

  @Test
  public void select_colors_from_dropdown_using_different_strategies() throws InterruptedException {
    WebElement colorDropdown = driver.findElement(By.id("oldSelectMenu")); //Old Style select menu


    //Conventional approach
    /*selectValueFromDropdown(colorDropdown, "Magenta", SelectStrategy.TEXT); //Magenta
    Thread.sleep(2000);
    selectValueFromDropdown(colorDropdown, "1", SelectStrategy.VALUE);  //Blue
    Thread.sleep(2000);
    selectValueFromDropdown(colorDropdown, "3", SelectStrategy.INDEX);  //Yellow
    Thread.sleep(2000);*/

    //Functional approach
    selectValueFromDropdownUsingFunctionalApproach(select -> select.selectByVisibleText("Magenta"), colorDropdown);
    Thread.sleep(1000);
    selectValueFromDropdownUsingFunctionalApproach(select -> select.selectByValue("1"), colorDropdown);
    Thread.sleep(1000);
    selectValueFromDropdownUsingFunctionalApproach(select -> select.selectByIndex(3), colorDropdown);
    Thread.sleep(1000);


    //Functional approach - Example 02
    List<WebElement> carOptions = new Select(driver.findElement(By.id("cars"))).getOptions();
    carOptions.stream().skip(2).forEach(WebElement::click);


  }

  //Functional approach
  private static void selectValueFromDropdownUsingFunctionalApproach(Consumer<Select> selectOperation, WebElement dropdown) {
    selectOperation.accept(new Select(dropdown));
  }

  //Conventional approach
  private static void selectValueFromDropdown(WebElement dropdown, String choice, SelectStrategy strategy) {
    Select select = new Select(dropdown);
    switch (strategy) {
      case TEXT -> select.selectByVisibleText(choice);
      case VALUE -> select.selectByValue(choice);
      case INDEX -> select.selectByIndex(Integer.parseInt(choice));
      default -> throw new RuntimeException(String.format("Invalid select strategy: %s", strategy.name()));
    }
  }

  public enum SelectStrategy {
    TEXT, VALUE, INDEX;
  }
}
