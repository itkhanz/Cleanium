package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.Actions;
import org.openqa.selenium.By;

public final class LoginPage {
  private By emailInput = By.id("Email");
  private By passwordInput = By.id("Password");
  private By loginBtn = By.xpath("//button[contains(@class, 'login-button')]");

  private LoginPage setEmail(String email) {
    Actions.onElement(emailInput).clear();
    Actions.onElement(emailInput).type(email);
    return this;
  }

  private LoginPage setPassword(String password) {
    Actions.onElement(passwordInput).clear();
    Actions.onElement(passwordInput).type(password);
    return this;
  }

  private DashboardPage clickLogin() {
    Actions.onElement(loginBtn).click();
    return new DashboardPage();
  }

  public DashboardPage performLogin(String email, String password) {
    return setEmail(email).setPassword(password).clickLogin();
  }
}
