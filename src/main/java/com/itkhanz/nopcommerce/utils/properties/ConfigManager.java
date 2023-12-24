package com.nopcommerce.utils.properties;

import com.nopcommerce.config.IPropertyConfig;
import com.nopcommerce.config.reader.PropertyReaderImpl;

/*
Configuration Manager for all config files i.e. Properties, JSON, YAML
 */
public class ConfigManager {

  public static IPropertyConfig getConfig() {
    return new PropertyReaderImpl().getConfiguration();
  }

  //Similarly create separate methods for JSON, and YamL config service layers here
}
