package com.nopcommerce.utils.properties;

import com.nopcommerce.config.IPropertyConfig;
import com.nopcommerce.config.reader.PropertyReaderImpl;

public class ConfigService {
  private static IPropertyConfig config = null;

  static {
    config = new PropertyReaderImpl().getConfiguration();
  }

  public static String getUserEmail() {
    return config.useremail();
  }

  public static String getPassword() {
    return config.password();
  }

  public static String getBaseUrl() {
    return config.baseURL();
  }
}
