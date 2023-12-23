package com.nopcommerce.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
  public static void captureScreenshotAsPNG(WebDriver driver, String testName) throws IOException {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
    FileUtils.copyFile(source, target);
    System.out.println("Screenshot taken");
  }
}
