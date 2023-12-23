package com.nopcommerce.config.reader;

import com.nopcommerce.config.IFrameworkConfig;
import com.nopcommerce.config.JsonConfig;

public interface IConfigReader {
  IFrameworkConfig getConfiguration();
}
