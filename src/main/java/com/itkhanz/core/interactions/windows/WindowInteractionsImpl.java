package com.itkhanz.core.interactions.windows;

import com.itkhanz.core.driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class WindowInteractionsImpl implements IWindowInteractions{
  @Override
  public void minimize() {
    DriverManager.getDriver().manage().window().minimize();
  }

  @Override
  public void maximize() {
    DriverManager.getDriver().manage().window().maximize();
  }

  @Override
  public void fullscreen() {
    DriverManager.getDriver().manage().window().fullscreen();
  }

  @Override
  public String getHandle() {
    return DriverManager.getDriver().getWindowHandle();
  }

  @Override
  public Set<String> getHandles() {
    return DriverManager.getDriver().getWindowHandles();
  }

  @Override
  public void switchTo(String windowHandle) {
    DriverManager.getDriver().switchTo().window(windowHandle);
  }

  @Override
  public void createAndSwitchToNewWindow() {
    DriverManager.getDriver().switchTo().newWindow(WindowType.WINDOW);
  }

  @Override
  public void createAndSwitchToNewTab() {
    DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
  }

  @Override
  public void close() {
    DriverManager.getDriver().close();
  }

  @Override
  public Dimension getSize() {
    return DriverManager.getDriver().manage().window().getSize();
  }

  @Override
  public void setSize(int width, int height) {
    DriverManager.getDriver().manage().window().setSize(new Dimension(width, height));
  }
}
