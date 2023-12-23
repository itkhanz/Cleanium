package com.nopcommerce.utils;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomUtils {
  private RandomUtils() {}

  //Facade pattern: Add an abstract layer whenever using a third party libraries
  //This method can change only when:
  //1. There is a change in business requirement
  //2. There is a change in third party library
  public static String getRandomString(int numOfDigits) {
    //perform the third party library change here
    return  RandomStringUtils.randomAlphabetic(numOfDigits);
  }

}
