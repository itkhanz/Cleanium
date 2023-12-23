package com.nopcommerce.config.reader;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.nopcommerce.config.FrameworkConfig;
import lombok.SneakyThrows;

import java.io.File;

public class PropertyReaderImpl implements IConfigReader {
  @SneakyThrows
  @Override
  public FrameworkConfig getConfiguration() {
    //jackson data-format to convert props to POJO
    return new JavaPropsMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "//src//test//resources//config.properties"),
        FrameworkConfig.class
      );
  }
}
