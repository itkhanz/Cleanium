package com.nopcommerce.utils.screenshot;

public class ScreenshotService {
  private ScreenshotService() {}

  public static String getScreenShotAsBase64() {
    return ScreenshotUtils.captureScreenshotAsBase64String();
  }
}
