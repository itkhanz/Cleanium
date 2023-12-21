package com.itkhanz.demos.part01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * Assignment:
 * 1. open Amazon.in
 * 2. fetch all the links on home page
 * 3. fetch all the text from links and remove empty links
 * 4. remove the duplicates
 * 5. sort the text in alphabetical order
 * 6. filter the text starting with letter C or D
 * 7. print the filtered text
 */
public class FunctionalProgramming {
  WebDriver driver;

  @BeforeTest
  private void setup() {
    driver = new ChromeDriver();
    driver.get("https://amazon.in");
  }

  @AfterTest
  private void teardown() {
    if (driver!= null) {
      driver.quit();
    }
  }

  /**
   * BAD (traditional) approach
   * using for loops and conditionals
   */
  @Test
  public void get_all_nonempty_links_starting_with_letters_a_or_c() {

    List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
    List<String> nonEmptyLinksText = new ArrayList<>();

    for (int i = 0; i< allLinks.size(); i++) {
      String linkText = allLinks.get(i).getText();
      if (!linkText.isBlank()) {
        nonEmptyLinksText.add(linkText);
      }
    }

      List<String> nonDuplicateLinksText = new ArrayList<>(new HashSet<String>(nonEmptyLinksText));
      Collections.sort(nonDuplicateLinksText);

      for (int i = 0; i < nonDuplicateLinksText.size(); i++) {
        if (nonDuplicateLinksText.get(i).startsWith("C") || nonDuplicateLinksText.get(i).startsWith("D")) {
          System.out.println(nonDuplicateLinksText.get(i));
        }
      }
    }

  /**
   * Good (Modern) approach
   * using Lambdas, Streams, Functional Programming, Method reference
   *
   */
  @Test
  public void get_all_nonempty_links_starting_with_letters_a_or_c_good() {

    Predicate<String> linksStartingLetter = text -> text.startsWith("C") || text.startsWith("D");

    driver.findElements(By.xpath("//a"))
      .stream()
      .map(WebElement::getText)
      .filter(s -> !s.isBlank())
      .distinct()
      .sorted()
      .filter(linksStartingLetter)
      .forEach(System.out::println);
  }
}

