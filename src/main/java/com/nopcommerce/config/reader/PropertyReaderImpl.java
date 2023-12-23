package com.nopcommerce.config.reader;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.nopcommerce.config.IFrameworkConfig;
import com.nopcommerce.config.IPropertyConfig;
import com.nopcommerce.config.JsonConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;

public class PropertyReaderImpl implements IConfigReader {
  @SneakyThrows
  @Override
  public IPropertyConfig getConfiguration() {

    IPropertyConfig propertyConfig = ConfigFactory.create(IPropertyConfig.class);
    return propertyConfig;

    //jackson data-format to convert props to POJO
    /*return new JavaPropsMapper()
      .readValue(
        new File(System.getProperty("user.dir") + "//src//test//resources//config.properties"),
        JsonConfig.class
      );*/
  }
}
