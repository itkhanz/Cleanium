package com.itkhanz.core.interactions.frames;

import com.itkhanz.core.driver.DriverManager;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import com.itkhanz.core.element.wait.WaitStrategy;
import org.openqa.selenium.By;

public class FrameInteractionsImpl implements IFramesInteractions{
  @Override
  public void switchToFrameByIndex(int index) {
    DriverManager.getDriver().switchTo().frame(index);
  }

  @Override
  public void switchToFrameByName(String name) {
    DriverManager.getDriver().switchTo().frame(name);
  }

  @Override
  public void switchToFrameByID(String id) {
    DriverManager.getDriver().switchTo().frame(id);
  }

  @Override
  public void switchToFrameByElement(By byLocator) {
    DriverManager.getDriver().switchTo().frame(WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, byLocator));
  }
}
