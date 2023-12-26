package com.itkhanz.nopcommerce.utils.readers;

import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.enums.Role;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.List;
import java.util.function.Supplier;

/*
Abstract Class which is the base for reading and mapping the excel data to POJOs using from Poiji library
 */
abstract class ExcelUtils {
  static Supplier<List<LoginData>> usersSupplier = () -> Poiji.fromExcel(
    new File(System.getProperty("user.dir") + "/src/test/resources/test-data/UserLoginCredentials.xlsx"),
    LoginData.class
  );

  public static LoginData getUserByRole(Role role) {
    return usersSupplier.get()
      .stream()
      .filter(user -> user.getRole().equalsIgnoreCase(role.name()))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("No User found with the role of: " + role.name()));
  }

  public static List<LoginData> getAllUsers() {
    return usersSupplier.get();
  }

}

