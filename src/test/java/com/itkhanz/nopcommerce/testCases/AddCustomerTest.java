package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.fixtures.UserDataProvider;
import com.itkhanz.nopcommerce.entities.UserData;
import com.itkhanz.nopcommerce.pages.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddCustomerTest extends BaseTest {

  @Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
  public void test_add_customer(UserData userData) {
    String alertText = LoginPage.createUsing(userData.getLoginData())
                        .performLogin()
                        .navigateCustomersPage()
                        .navigateToAddNewCustomerPage()
                        .addNewCustomer(userData.getCustomerData())
                        .getAlertText();

    assertThat(alertText).contains("The new customer has been added successfully");
  }
}
