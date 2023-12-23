package com.nopcommerce.testCases;

import com.nopcommerce.config.reader.PropertyReaderImpl;

public class Runner {
  public static void main(String[] args) {
    System.out.println(new PropertyReaderImpl().getConfiguration().getPassword());
  }
}
