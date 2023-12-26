package com.itkhanz.nopcommerce.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class LoginData {
  private String email;
  private String password;
}
