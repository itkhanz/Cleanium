package com.itkhanz.demos.part11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
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
  public void test_remove_elements_from_list() {
   Predicate<Integer> isOdd = i -> i%2 != 0;
   Predicate<Integer> isDivBy3 = i -> i%3 == 0;

   List<Integer> originalList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

   //Approach 01
   List<Integer> modifiedList = originalList.stream().filter(isOdd.or(isDivBy3).negate()).toList();
   System.out.println("Modified List: " + modifiedList);

   //Appaorch 02
    originalList.removeIf(isOdd.or(isDivBy3));
    System.out.println("Original List: " + originalList);

  }

  @Test
  public void test_click_element_with_matching_criteria() {
    List<WebElement> allElements = driver.findElements(By.xpath("//li//a"));
    click_element_with_criteria(allElements, e -> e.getAttribute("href").endsWith("/checkboxes"));
  }

  private void click_element_with_criteria(List<WebElement> elementList, Predicate<WebElement> criteria) {
    //Approach 01
    /*elementList.stream().parallel()
      .filter(criteria)
      .findFirst()
      .ifPresent(WebElement::click);
    ;*/

    //Approach 02
    WebElement element = elementList.stream().parallel()
      .filter(criteria)
      .findFirst()
      .orElseThrow(() -> new RuntimeException("Failed to find the element matching criteria"));
    element.click();
  }

  @Test
  public void test_partition_by_rule() {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    Predicate<Integer> isEven = num -> num%2==0;
    Map<Boolean, List<Integer>> booleanListMap = partition_by_rule(numbers, isEven);

    System.out.println(booleanListMap.get(true)); //even
    System.out.println(booleanListMap.get(false)); //odd
  }

  private Map<Boolean, List<Integer>> partition_by_rule(List<Integer> numbers, Predicate<Integer> rule) {
    return numbers.stream().parallel().collect(Collectors.partitioningBy(rule));
  }
}
