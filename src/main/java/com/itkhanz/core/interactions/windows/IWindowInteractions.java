package com.itkhanz.core.interactions.windows;

import org.openqa.selenium.Dimension;

import java.util.Set;

public interface IWindowInteractions {
  void minimize();
  void maximize();

  void fullscreen();

  String getHandle();

  Set<String> getHandles();

  void switchTo(String windowHandle);

  void createAndSwitchToNewWindow();
  void createAndSwitchToNewTab();

  void close();

  Dimension getSize();

  void setSize(int width, int height);

}
