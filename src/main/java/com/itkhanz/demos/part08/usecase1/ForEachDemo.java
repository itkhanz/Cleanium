package com.itkhanz.demos.part08.usecase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class ForEachDemo {
  WebDriver driver;

  @BeforeTest
  private void setup() {
    driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/");
  }

  @AfterTest
  private void teardown() {
    if (driver!= null) {
      driver.quit();
    }
  }

  @Test
  public void print_all_non_empty_links() {
    List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

    //Conventional approach using for loop
    /*for (int i = 0; i< allLinks.size(); i++) {
      String linkText = allLinks.get(i).getText();
      if (!linkText.isBlank()) {
        System.out.println(linkText);
      }
    }*/

    //Functional approach using Consumer and for each loop
    Consumer<WebElement> printNonEmptyLinkText = element -> {
      if (!element.getText().isBlank()){
        System.out.println(element.getText());
      }
    };

    allLinks.forEach(printNonEmptyLinkText);
  }
}
