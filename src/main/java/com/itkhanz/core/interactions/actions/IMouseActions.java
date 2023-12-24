package com.itkhanz.core.interactions.actions;

import org.openqa.selenium.By;

public interface IMouseActions extends IActions{
  void clickAndHold(By byLocator);
  void click(By byLocator);
  void contextClick(By byLocator);
  void doubleClick(By byLocator);
  void hover(By byLocator);
}
