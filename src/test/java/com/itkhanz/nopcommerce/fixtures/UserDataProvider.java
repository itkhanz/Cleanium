package com.itkhanz.nopcommerce.fixtures;

import com.itkhanz.nopcommerce.entities.PojoFactory;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

  @DataProvider
  public static Object[][] getUserData() {
    return new Object[][] {
      { PojoFactory.createUserData() }
    };
  }

  @DataProvider
  public static Object[][] getLoginUserData() {

    return new Object[][] {
      { PojoFactory.createLoginData() }
    };
  }

}
