package com.itkhanz.nopcommerce.fixtures;

import com.itkhanz.nopcommerce.entities.CustomerData;
import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.entities.UserData;
import com.itkhanz.nopcommerce.enums.Role;
import com.itkhanz.nopcommerce.utils.faker.FakerService;
import com.itkhanz.nopcommerce.utils.random.RandomService;
import com.itkhanz.nopcommerce.utils.readers.TestDataReader;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

  @DataProvider
  public static Object[][] getLoginData() {

    LoginData loginData = TestDataReader.getUserByRole(Role.ADMIN);

    CustomerData customerData = CustomerData
      .builder()
      .setEmail(FakerService.getEmail())
      .setPassword(FakerService.getPassword())
      .setGender(RandomService.getRandomGender())
      .build();

    UserData userData = UserData
      .builder()
      .setLoginData(loginData)
      .setCustomerData(customerData)
      .build();

    return new Object[][] {
      {userData}
    };
  }

}
