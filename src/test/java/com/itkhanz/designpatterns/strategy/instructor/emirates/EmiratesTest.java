package com.itkhanz.designpatterns.strategy.instructor.emirates;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.strategy.instructor.emirates.components.search.FlightSearch;
import com.itkhanz.designpatterns.strategy.instructor.emirates.components.search.MultiWay;
import com.itkhanz.designpatterns.strategy.instructor.emirates.components.search.OneWay;
import com.itkhanz.designpatterns.strategy.instructor.emirates.components.search.TwoWay;
import com.itkhanz.designpatterns.strategy.instructor.emirates.pages.EmiratesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EmiratesTest extends BaseTest {
  private EmiratesPage emiratesPage;

  @BeforeMethod
  public void setPaymentScreen(){
    this.emiratesPage = new EmiratesPage(this.driver);
  }

  @Test(dataProvider = "getData")
  public void paymentTest(FlightSearch flightSearch, Map<String, String> searchDetails){
    this.emiratesPage.goTo();
    this.emiratesPage.setFlightSearch(flightSearch);
    this.emiratesPage.searchForFlights(searchDetails);
  }

  @DataProvider
  public Object[][] getData(){
    Map<String, String> map = new HashMap<>();
    map.put("departureCity", "Austin (AUS)");
    map.put("arrivalCity", "Houston (IAH)");
    map.put("arrivalCity2", "Las Vegas (LAS)");

    return new Object[][] {
      {new OneWay(), map},
      {new TwoWay(), map},
      {new MultiWay(), map},
    };
  }

}
