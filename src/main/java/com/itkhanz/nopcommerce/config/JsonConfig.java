package com.itkhanz.nopcommerce.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonConfig implements IFrameworkConfig {

  private String baseURL;
  private String useremail;
  private String password;

}
