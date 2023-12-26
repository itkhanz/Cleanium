package com.itkhanz.nopcommerce.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class UserData {
  private LoginData loginData;
  private CustomerData customerData;
}
