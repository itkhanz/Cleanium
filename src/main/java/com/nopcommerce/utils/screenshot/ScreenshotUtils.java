package com.nopcommerce.utils.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

  //TODO make driver thread-safe
  static WebDriver driver;

  static String captureScreenshotAsBase64String() {
    TakesScreenshot ts = (TakesScreenshot) driver;
    return  ts.getScreenshotAs(OutputType.BASE64);
  }
}
