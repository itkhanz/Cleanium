package com.itkhanz.core.element.locator;

public final class XPathProvider {
  private XPathProvider() {}

  public static String createXPath(String xpath, String dynamicValue) {
    return String.format(xpath, dynamicValue);
  }
}
