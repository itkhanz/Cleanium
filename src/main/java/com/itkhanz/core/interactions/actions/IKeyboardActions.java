package com.itkhanz.core.interactions.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public interface IKeyboardActions extends IActions{
  KeyboardActionsImpl keyDown(Keys keys);
  KeyboardActionsImpl keyUp(Keys keys);
  KeyboardActionsImpl sendKeys(String keys);
  KeyboardActionsImpl sendKeys(Keys keys);
  KeyboardActionsImpl sendKeys(By byLocator, String keys);

}
