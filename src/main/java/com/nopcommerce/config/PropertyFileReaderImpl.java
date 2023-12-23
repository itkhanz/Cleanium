package com.nopcommerce.config;

import java.util.Map;

public class PropertyFileReaderImpl implements IConfigReader{
  @Override
  public FrameworkProps getConfiguration() {
    return new FrameworkProps("http://admin-demo.nopcommerce.com", "admin@yourstore.com", "admin");
  }
}
