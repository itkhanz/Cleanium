package com.itkhanz.core.browser;

import java.util.stream.Stream;

public class BrowserManager {
  public static Browser getMatchingBrowser(String browserName) {
    return Stream.of(Browser.values())
      .filter(browser -> browser.name().equalsIgnoreCase(browserName))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("No enum constant found for this browser name: " + browserName));
  }
}
