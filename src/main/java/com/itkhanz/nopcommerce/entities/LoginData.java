package com.itkhanz.nopcommerce.entities;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;

@Getter
public class LoginData {

  @ExcelCellName("role")
  private String role;

  @ExcelCellName("email")
  private String email;

  @ExcelCellName("password")
  private String password;
}
