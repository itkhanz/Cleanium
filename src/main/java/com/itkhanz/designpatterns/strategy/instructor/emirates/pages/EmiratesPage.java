package com.itkhanz.designpatterns.strategy.instructor.emirates.pages;

import com.itkhanz.designpatterns.strategy.instructor.emirates.components.DatePicker;
import com.itkhanz.designpatterns.strategy.instructor.emirates.components.search.FlightSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class EmiratesPage {
  private final WebDriver driver;
  private final WebDriverWait wait;

  private FlightSearch flightSearch;
  private final By seassionExpired = By.className("ts-session-expire--link");

  private final By acceptCookiesBtn = By.id("onetrust-accept-btn-handler");

  public EmiratesPage(final WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void goTo(){
    this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");

    //accept cookies
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(acceptCookiesBtn))
      .stream()
      .findFirst()
      .ifPresent(WebElement::click);

    //start new search session
    this.driver.findElements(seassionExpired)
      .stream()
      .findFirst()
      .ifPresent(WebElement::click);
  }

  public void setFlightSearch(FlightSearch flightSearch){
    this.flightSearch = flightSearch;
    PageFactory.initElements(driver, this.flightSearch);
    this.flightSearch.setDatePicker(PageFactory.initElements(driver, DatePicker.class));
  }

  public void searchForFlights(Map<String, String> searchDetails){
    this.flightSearch.search(searchDetails);
  }
}
