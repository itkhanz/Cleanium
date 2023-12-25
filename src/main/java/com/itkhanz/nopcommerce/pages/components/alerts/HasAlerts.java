package com.itkhanz.nopcommerce.pages.components.alerts;

import com.itkhanz.core.element.actions.Actions;
import org.openqa.selenium.By;

public interface HasAlerts {
  static final By alertMessage = By.xpath("//div[contains(@class, 'alert')]");

  default String getAlertText() {
    return Actions.onElement(alertMessage).getText();
  }
}
