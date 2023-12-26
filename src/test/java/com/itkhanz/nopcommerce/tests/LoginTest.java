package com.itkhanz.nopcommerce.tests;

import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.fixtures.UserDataProvider;
import com.itkhanz.nopcommerce.pages.DashboardPage;
import com.itkhanz.nopcommerce.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
  @Test(dataProvider = "getLoginUserData", dataProviderClass = UserDataProvider.class)
  public void test_login_with_admin(LoginData loginData) {
    DashboardPage dashboardPage = LoginPage.createUsing(loginData).performLogin();

    Assertions.assertThat(dashboardPage.isDashboardDisplayed()).isTrue();
  }
}
