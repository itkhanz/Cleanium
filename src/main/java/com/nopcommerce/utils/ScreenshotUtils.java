package com.nopcommerce.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

  static WebDriver driver;
  public static void captureScreenshotAsPNG(String testName) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
    copyFile(source, target);
  }

  private static void copyFile(File source, File target) {
    try {
      FileUtils.copyFile(source, target);
      System.out.println("Screenshot saved");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String captureScreenshotAsBase64Image() {
    TakesScreenshot ts = (TakesScreenshot) driver;
    return  ts.getScreenshotAs(OutputType.BASE64);
  }
}
