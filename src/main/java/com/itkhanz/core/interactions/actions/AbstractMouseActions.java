package com.itkhanz.core.interactions.actions;

import org.openqa.selenium.interactions.Actions;

public abstract class AbstractMouseActions extends AbstractActions {
  protected void performActions(Actions actions) {
    actions.perform();
  }
}
