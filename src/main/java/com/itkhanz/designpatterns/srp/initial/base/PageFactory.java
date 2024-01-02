package com.itkhanz.designpatterns.srp.initial.base;


import com.itkhanz.designpatterns.srp.initial.pages.BasePage;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class PageFactory {

  private static final Map<Class<? extends BasePage>, BasePage> pages = new HashMap<>();

  @SneakyThrows
  public static <T extends BasePage> T createPage(Class<? extends BasePage> pageClass) {
    // Check if an instance of the page class already exists
    if (!pages.containsKey(pageClass)) {
      try {
        // If not, create a new instance and put it in the map
        pages.put(pageClass, pageClass.getDeclaredConstructor().newInstance());
      } catch (Exception e) {
        throw new RuntimeException("The Page could not be created: " + pageClass.getName(), e);
      }
    }
    // Return the instance (new or existing)
    return (T) pages.get(pageClass);
  }

}
