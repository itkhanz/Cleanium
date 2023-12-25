package com.itkhanz.core.interactions.actions;

import com.itkhanz.core.element.wait.ElementWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class KeyboardActionsImpl extends AbstractKeyboardActions implements IKeyboardActions{

  public KeyboardActionsImpl() {
    actions = getNativeActions();
  }

  @Override
  public KeyboardActionsImpl keyDown(Keys keys) {
    actions.keyDown(keys);
    return this;
  }

  @Override
  public KeyboardActionsImpl keyUp(Keys keys) {
    actions.keyUp(keys);
    return this;
  }

  @Override
  public KeyboardActionsImpl sendKeys(String keys) {
    actions.sendKeys(keys);
    return this;
  }

  @Override
  public KeyboardActionsImpl sendKeys(Keys keys) {
    actions.sendKeys(keys);
    return this;
  }

  @Override
  public KeyboardActionsImpl sendKeys(By byLocator, String keys) {
    actions.sendKeys(WaitFactory.performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, byLocator),keys);
    return this;
  }

}
