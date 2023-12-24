package com.itkhanz.core.interactions.frames;

import org.openqa.selenium.By;

public interface IFramesInteractions {
  void switchToFrameByIndex(int index);
  void switchToFrameByName(String name);
  void switchToFrameByID(String id);

  void switchToFrameByElement(By byLocator);
}
