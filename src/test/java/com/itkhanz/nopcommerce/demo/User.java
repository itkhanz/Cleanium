package com.itkhanz.nopcommerce.demo;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;

@Getter
public class User {

  @ExcelCellName("role")
  private String role;

  @ExcelCellName("email")
  private String email;

  @ExcelCellName("password")
  private String password;

}
