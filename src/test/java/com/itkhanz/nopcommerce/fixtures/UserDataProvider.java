package com.itkhanz.nopcommerce.fixtures;

import com.itkhanz.nopcommerce.entities.CustomerData;
import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.entities.UserData;
import com.itkhanz.nopcommerce.utils.faker.FakerService;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import com.itkhanz.nopcommerce.utils.random.RandomService;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

  @DataProvider
  public static Object[][] getLoginData() {

    LoginData loginData = LoginData
      .builder()
      .setEmail(ConfigService.getUserEmail())
      .setPassword(ConfigService.getPassword())
      .build();

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
