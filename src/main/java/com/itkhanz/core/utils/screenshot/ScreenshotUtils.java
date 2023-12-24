package com.itkhanz.core.utils.screenshot;

import com.itkhanz.core.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

  static String captureScreenshotAsBase64String() {
    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
    return  ts.getScreenshotAs(OutputType.BASE64);
  }

}
