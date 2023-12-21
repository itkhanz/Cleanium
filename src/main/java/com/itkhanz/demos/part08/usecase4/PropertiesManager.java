package com.itkhanz.demos.part08.usecase4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;

class PropertiesManager {
  public static void main(String[] args) throws IOException {
    Path filePath = Path.of("src/main/java/com/itkhanz/demos/part08/usecase4/config/config.properties").toAbsolutePath();
    //System.out.println(filePath.toString());

    Properties props = new Properties();
    props.load(new FileInputStream(filePath.toFile()));

    //conventional approach
    for (Map.Entry<Object, Object> prop : props.entrySet()) {
      System.out.println(prop.getKey() + " : " + prop.getValue());
    }

    //functional approach -> forEach accepts BiConsumer
    BiConsumer<Object, Object> printProperty = (key, value) -> System.out.println(key + " : " + value);
    props.forEach(printProperty);

    //props.entrySet().forEach(prop -> System.out.println(prop.getKey() + " : " + prop.getValue()));
  }
}
