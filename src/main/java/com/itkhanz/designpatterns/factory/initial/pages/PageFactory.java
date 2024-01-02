package com.itkhanz.designpatterns.factory.initial.pages;

import com.itkhanz.designpatterns.factory.initial.pages.home.FrenchHomePage;
import com.itkhanz.designpatterns.factory.initial.pages.home.EnglishHomePage;
import com.itkhanz.designpatterns.factory.initial.pages.home.HomePage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
  public static HomePage createHomePage(String country, WebDriver driver) {
    switch (country.toLowerCase()){
      case "france" -> {
        return new FrenchHomePage(driver);
      }
      case "english" -> {
        return new EnglishHomePage(driver);
      }
      default -> throw new RuntimeException("Not page found for country: " + country);
    }
  }
}
