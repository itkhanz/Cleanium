package com.itkhanz.nopcommerce.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class CustomerData {
  private String email;
  private String password;
  private String gender;
}
