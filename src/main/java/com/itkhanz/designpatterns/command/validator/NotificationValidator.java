package com.itkhanz.designpatterns.command.validator;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator{

  private final WebElement button;
  private final WebElement notification;

  private final String elementDescription;

  public NotificationValidator(final WebElement button, final WebElement notification, final String description){
    this.button = button;
    this.notification = notification;
    this.elementDescription = description;
  }

  @Override
  public boolean validate() {
    this.button.click();
    boolean appearanceState = this.notification.isDisplayed(); //true
    Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    boolean disappearanceState = this.notification.isDisplayed(); // false
    return appearanceState && (!disappearanceState);
  }

  @Override
  public String getMessage() {
    return "Failed to validate the notification toast for " + elementDescription;
  }
}
