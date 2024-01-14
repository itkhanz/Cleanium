package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import com.itkhanz.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BrokenLinkTest {
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

  @Test
  public void find_broken_links_test() {
    driver.get("https://the-internet.herokuapp.com/broken_images");

    //elements like images, js files have src attribute instead of href
    List<Map<String, Integer>> brokenLinks = driver.findElements(By.xpath("//*[@src]"))
      .stream()
      .map(element -> element.getAttribute("src"))
      .map(source -> Map.entry(source, LinkUtil.getResponseCode(source)))
      .filter(entry -> entry.getValue() != 200)
      .map(entry -> Collections.singletonMap(entry.getKey(), entry.getValue()))
      .toList();

    brokenLinks.forEach(System.out::println);

    Assert.assertEquals(brokenLinks.size(), 0);

  }
}
