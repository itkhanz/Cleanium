package com.itkhanz.nopcommerce.tests;

import com.itkhanz.nopcommerce.constants.CustomerAlerts;
import com.itkhanz.nopcommerce.entities.UserData;
import com.itkhanz.nopcommerce.fixtures.UserDataProvider;
import com.itkhanz.nopcommerce.pages.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddCustomerTest extends BaseTest {

  @Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
  public void test_add_customer(UserData userData) {
    String alertText = LoginPage.createUsing(userData.getLoginData())
                        .performLogin()
                        .navigateToCustomersPage()
                        .navigateToCustomerDetailsPage(userData.getCustomerData())
                        .addNewCustomer()
                        .getAlertText();

    assertThat(alertText).contains(CustomerAlerts.SUCCESS_NEW_CUSTOMER_CREATED);
  }

  @Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
  public void test_add_customer_without_mandatory_fields(UserData userData) {
    String alertText = LoginPage.createUsing(userData.getLoginData())
                        .performLogin()
                        .navigateToCustomersPage()
                        .navigateToCustomerDetailsPage(userData.getCustomerData())
                        .addNewCustomerWithOptionalFields()
                        .getAlertText();

    assertThat(alertText).contains(CustomerAlerts.FAILURE_PROVIDE_VALID_EMAIL);
  }
}
