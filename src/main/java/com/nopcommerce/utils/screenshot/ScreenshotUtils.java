package com.nopcommerce.utils.screenshot;

import com.nopcommerce.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

  static String captureScreenshotAsBase64String() {
    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
    return  ts.getScreenshotAs(OutputType.BASE64);
  }

}
