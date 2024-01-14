package com.itkhanz.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxTest {
  private WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }


  /*
  selects the checkboxes based on search criteria
   */
  @Test(dataProvider = "getCriteria")
  public void checkboxesTest(Predicate<List<WebElement>> searchCriteria){
    //driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");  //contains an empty row

    List<WebElement> allRows = driver.findElements(By.xpath("//tr"));

    allRows.stream()
      .skip(1)                                                        //skips the header row
      .parallel()                                                       //processes the stream in parallel
      .map(row -> row.findElements(By.xpath(".//td")))     //find all the columns
      .filter(cols -> cols.size() == 4)                                 //check the no of cols is equal to 4 i.e. row is not empty
      .filter(searchCriteria)                                           //filter the row based on criteria
      .map(cols -> cols.get(3).findElement(By.xpath(".//input[@type='checkbox']")))                                         //get the checkbox column
      .forEach(WebElement::click);                                      //select the gender checkbox

    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  }


  @DataProvider
  private Object[][] getCriteria() {
    //you can also create a CriteriaFactory and pass get criteria as map key-value
    Predicate<List<WebElement>> allMale = cols -> cols.get(1).getText().equalsIgnoreCase("male");
    Predicate<List<WebElement>> allFemale = cols -> cols.get(1).getText().equalsIgnoreCase("female");
    Predicate<List<WebElement>> anyGender = allMale.or(allFemale);
    Predicate<List<WebElement>> allAU = cols -> cols.get(2).getText().equalsIgnoreCase("AU");
    Predicate<List<WebElement>> allFemaleAU = allFemale.and(allAU);

    return new Object[][] {
      { allMale },
      { allFemale },
      { anyGender },
      { allFemaleAU }
    };
  }



}
