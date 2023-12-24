package com.itkhanz.nopcommerce.config.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itkhanz.nopcommerce.config.JsonConfig;
import lombok.SneakyThrows;

import java.io.File;

public class JsonReaderImpl implements IConfigReader{
  @SneakyThrows
  @Override
  public JsonConfig getConfiguration() {
    //Jackson lib to convert JSON to POJO
    return new ObjectMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "//src//test//resources//config.json"),
        JsonConfig.class
      );
  }
}
