package com.nopcommerce.testCases;

import com.nopcommerce.config.reader.JsonReaderImpl;
import com.nopcommerce.config.reader.PropertyReaderImpl;

public class Runner {
  public static void main(String[] args) {
    System.out.println(new PropertyReaderImpl().getConfiguration().baseURL());
    System.out.println(new JsonReaderImpl().getConfiguration().getBaseURL());
  }
}
