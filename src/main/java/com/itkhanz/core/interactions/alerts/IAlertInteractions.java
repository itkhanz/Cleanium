package com.itkhanz.core.interactions.alerts;

import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import org.openqa.selenium.Alert;

public interface IAlertInteractions {

  default Alert getNativeAlert() {
    return WaitFactory.waitForAlert(WaitDuration.MEDIUM);
  }

  String getText();
  void accept();
}
