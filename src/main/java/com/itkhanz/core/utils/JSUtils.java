package com.itkhanz.core.utils;

import com.itkhanz.core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtils {
  private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();

  private static void execute(String script) {
    javascriptExecutor.executeScript(script);
  }

  private static void execute(String script, By byLocator) {
    javascriptExecutor.executeScript(script, DriverManager.getDriver().findElement(byLocator));
  }

  public static void scrollElementIntoView(By byLoctor) {
    JSUtils.execute("arguments[0].scrollIntoView(true);", byLoctor);
  }

  public static void scrollToBottomOfPage() {
    JSUtils.execute("window.scrollTo(0, document.body.scrollHeight)");
  }

  public static void scrollByPixel(int horizontalPx, int verticalPx) {
    JSUtils.execute(String.format("window.scrollBy(%d,%d)", horizontalPx, verticalPx));
  }
}
