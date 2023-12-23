package com.nopcommerce.config.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopcommerce.config.FrameworkConfig;
import lombok.SneakyThrows;

import java.io.File;

public class JsonReaderImpl implements IConfigReader{
  @SneakyThrows
  @Override
  public FrameworkConfig getConfiguration() {
    //Jackson lib to convert JSON to POJO
    return new ObjectMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "//src//test//resources//config.json"),
        FrameworkConfig.class
      );
  }
}
