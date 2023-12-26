package com.itkhanz.nopcommerce.utils.readers;

import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.enums.Role;

import java.util.List;

/*
TestDataReader helps us to hide the ExcelService from end-user
Later if test data is JSON, then we can simple use the JsonService to read the data and return using same method
 */
public class TestDataReader {

  public static LoginData getUserByRole(Role role) {
    return ExcelService.getUserByRole(role);
  }

  public static List<LoginData> getAllUsers() {
    return ExcelService.getAllUsers();
  }
}
