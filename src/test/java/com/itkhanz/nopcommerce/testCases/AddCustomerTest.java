package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.pages.LoginPage;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddCustomerTest extends BaseTest {

  @Test
  public void test_add_customer() {
    String alertText = new LoginPage()
      .performLogin(ConfigService.getUserEmail(), ConfigService.getPassword())
      .navigateCustomersPage()
      .navigateToAddNewCustomerPage()
      .addNewCustomer("abwcd@gmail.com", "xxx", "female")
      .getAlertText();

    System.out.println(alertText);
    assertThat(alertText).contains("The new customer has been added successfully");
  }
}
