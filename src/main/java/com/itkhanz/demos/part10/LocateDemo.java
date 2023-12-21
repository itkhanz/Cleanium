package com.itkhanz.demos.part10;

import com.itkhanz.demos.part09.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LocateDemo {
  @BeforeTest
  private void setup() {
    DriverFactory.initializeDriver(Browser.CHROME);
    DriverManager.getDriver().get("https://the-internet.herokuapp.com/");
  }

  @AfterTest
  private void teardown() {
    DriverManager.terminateDriver();
  }

  @Test
  public void test_locator_and_waiter_with_logging() {
    Locator inputsMenu = Locator.builder().strategy(LocatorStrategy.LINK_TEXT).value("Inputs").build();

    //Approach 01
    System.out.println(LocatorFactory.getWebElement(inputsMenu).getAttribute("href"));
    //Approach 02
    System.out.println(WebElementActions.getAttribute(inputsMenu, "href"));

    WebElementActions.click(inputsMenu);

    Locator textField = Locator.builder().strategy(LocatorStrategy.XPATH).value("//div[@class='example']//input").build();
    WebElementActions.type(textField, "123");
  }

  @Test
  public void test_simplified_get_information_from_element() {
    Locator allLinksLoc = Locator.builder().strategy(LocatorStrategy.XPATH).value("//li//a").build();
    List<WebElement> allLinks = LocatorFactory.getWebelementsList(allLinksLoc);

    //Get all link texts, href, and tags
    List<String> allLinksTexts = getElementInfo(allLinks, WebElement::getText);
    List<String> allLinksTags = getElementInfo(allLinks, WebElement::getTagName);
    List<String> allLinksHref = getElementInfo(allLinks, e -> e.getAttribute("href"));

    allLinksTexts.forEach(System.out::println);

  }

  private List<String> getElementInfo(List<WebElement> elements, Function<WebElement, String> elementOperation) {
    return elements.stream().map(elementOperation).collect(Collectors.toList());
  }

}
