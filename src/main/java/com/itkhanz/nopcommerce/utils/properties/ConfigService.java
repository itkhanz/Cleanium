package com.itkhanz.nopcommerce.utils.properties;


public class ConfigService {

  public static String getUserEmail() {
    return ConfigManager.getConfig().useremail();
  }

  public static String getPassword() {
    return ConfigManager.getConfig().password();
  }

  public static String getBaseUrl() {
    return ConfigManager.getConfig().baseURL();
  }
}
