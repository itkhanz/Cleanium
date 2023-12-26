package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.nopcommerce.entities.LoginData;
import org.openqa.selenium.By;

public final class LoginPage {
  private String email;
  private String password;

  private LoginPage(LoginData loginData) {
    this.email = loginData.getEmail();
    this.password = loginData.getPassword();
  }

  public static LoginPage createUsing(LoginData loginData) {
    return new LoginPage(loginData);
  }

  private static final By emailInput = By.id("Email");
  private static final By passwordInput = By.id("Password");
  private static final By loginBtn = By.xpath("//button[contains(@class, 'login-button')]");

  private LoginPage setEmail() {
    Actions.onElement(emailInput).clear();
    Actions.onElement(emailInput).type(email);
    return this;
  }

  private LoginPage setPassword() {
    Actions.onElement(passwordInput).clear();
    Actions.onElement(passwordInput).type(password);
    return this;
  }

  private DashboardPage clickLogin() {
    Actions.onElement(loginBtn).click();
    return new DashboardPage();
  }

  public DashboardPage performLogin() {
    return setEmail().setPassword().clickLogin();
  }
}
