package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.ElementActions;
import org.openqa.selenium.By;

public final class LoginPage {
  private By emailInput = By.id("Email");
  private By passwordInput = By.id("Password");
  private By loginBtn = By.xpath("//button[contains(@class, 'login-button')]");

  private LoginPage setEmail(String email) {
    ElementActions.clear(emailInput);
    ElementActions.type(emailInput, email);
    return this;
  }

  private LoginPage setPassword(String password) {
    ElementActions.clear(passwordInput);
    ElementActions.type(passwordInput, password);
    return this;
  }

  private DashboardPage clickLogin() {
    ElementActions.click(loginBtn);
    return new DashboardPage();
  }

  public DashboardPage performLogin(String email, String password) {
    return setEmail(email).setPassword(password).clickLogin();
  }
}
