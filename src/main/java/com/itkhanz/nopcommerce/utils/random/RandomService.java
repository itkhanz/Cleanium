package com.nopcommerce.utils.random;

/*
Abstract  layer on top of RandomUtils (which could be a third party library)
 */
public final class RandomService {
  private RandomService() {}

  //perform the business change here
  public static String getRandomEmail() {
    return RandomUtils.getRandomString(5) + "@gmail.com";
  }
}
