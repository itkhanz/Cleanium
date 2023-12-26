package com.itkhanz.nopcommerce.utils.readers;

import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.enums.Role;

import java.util.List;


/*
ExcelService allows us to abstract the internals of abstract ExcelUtils (Poiji library)
ExcelService method signatures is not impacted by later change in the excel reader library
 */
class ExcelService {
  static LoginData getUserByRole(Role role) {
    return ExcelUtils.getUserByRole(role);
  }

  static List<LoginData> getAllUsers() {
    return ExcelUtils.getAllUsers();
  }

}
