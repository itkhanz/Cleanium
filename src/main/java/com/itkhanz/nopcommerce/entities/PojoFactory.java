package com.itkhanz.nopcommerce.entities;

import com.itkhanz.nopcommerce.enums.Role;
import com.itkhanz.nopcommerce.utils.faker.FakerService;
import com.itkhanz.nopcommerce.utils.random.RandomService;
import com.itkhanz.nopcommerce.utils.readers.TestDataReader;

public class PojoFactory {
  public static LoginData createLoginData() {
    return TestDataReader.getUserByRole(Role.ADMIN);
  }

  public static CustomerData createCustomerData() {
    return CustomerData
      .builder()
      .setEmail(FakerService.getEmail())
      .setPassword(FakerService.getPassword())
      .setGender(RandomService.getRandomGender())
      .build();
  }

  public static UserData createUserData() {
    return UserData.builder()
      .setLoginData(PojoFactory.createLoginData())
      .setCustomerData(PojoFactory.createCustomerData())
      .build();
  }
}
