package com.itkhanz.core.interactions.actions;

import com.itkhanz.core.driver.DriverManager;
import org.openqa.selenium.interactions.Actions;

public interface IActions {
  default Actions getNativeActions() {
    return new Actions(DriverManager.getDriver());
  }

}
