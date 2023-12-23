package com.nopcommerce.utils;

public final class RandomService {
  private RandomService() {}

  //perform the business change here
  public static String getRandomEmail() {
    return RandomUtils.getRandomString(5) + "@gmail.com";
  }
}
