package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.pages.LoginPage;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import org.testng.annotations.Test;

public class AddCustomerTest extends BaseTest {

  @Test
  public void test_add_customer() {
    new LoginPage()
      .performLogin(ConfigService.getUserEmail(), ConfigService.getPassword())
      .navigateToAddCustomersPage();
  }
}
