package com.itkhanz.nopcommerce.utils.random;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public final class RandomUtils {
  private static final Random random = new Random();
  private RandomUtils() {}

  //Facade pattern: Add an abstract layer whenever using a third party libraries
  //This method can change only when:
  //1. There is a change in business requirement
  //2. There is a change in third party library
  static String getRandomString(int numOfDigits) {
    //perform the third party library change here
    return  RandomStringUtils.randomAlphabetic(numOfDigits);
  }

  static int getRandomBinary() {
    return random.nextInt(2);  // Generates 0 or 1
  }

}
