package com.itkhanz.nopcommerce.demo;

import com.itkhanz.nopcommerce.entities.LoginData;
import com.itkhanz.nopcommerce.enums.Role;
import com.itkhanz.nopcommerce.utils.readers.TestDataReader;

import java.util.List;

public class Demo {
  public static void main(String[] args) {

    List<LoginData> users = TestDataReader.getAllUsers();
    System.out.println(users.size());

    LoginData user = TestDataReader.getUserByRole(Role.ADMIN);
    System.out.println(user.getRole());
    System.out.println(user.getEmail());
    System.out.println(user.getPassword());
  }
}
