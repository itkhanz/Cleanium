package com.itkhanz.core.interactions.actions;

import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import com.itkhanz.core.element.wait.WaitStrategy;
import org.openqa.selenium.By;

public class MouseActionsImpl extends AbstractMouseActions implements IMouseActions{

  public MouseActionsImpl() {
    actions = getNativeActions();
  }

  @Override
  public void clickAndHold(By byLocator) {
    performActions(actions.clickAndHold(WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, WaitDuration.WAIT_MEDIUM, byLocator)));
  }

  @Override
  public void click(By byLocator) {
    performActions(actions.click(WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, WaitDuration.WAIT_MEDIUM, byLocator)));
  }

  @Override
  public void contextClick(By byLocator) {
    performActions(actions.contextClick(WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, WaitDuration.WAIT_MEDIUM, byLocator)));
  }

  @Override
  public void doubleClick(By byLocator) {
    performActions(actions.doubleClick(WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, WaitDuration.WAIT_MEDIUM, byLocator)));
  }

  @Override
  public void hover(By byLocator) {
    performActions(actions.moveToElement(WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, WaitDuration.WAIT_MEDIUM, byLocator)));
  }
}
