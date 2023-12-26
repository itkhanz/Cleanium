package com.itkhanz.nopcommerce.utils.random;

/*
Abstract  layer on top of RandomUtils (which could be a third party library)
 */
public final class RandomService {
  private RandomService() {}

  //perform the business change here
  public static String getRandomEmail() {
    return RandomUtils.getRandomString(5) + "@gmail.com";
  }

  public static String getRandomGender() {
    int randomNumber = RandomUtils.getRandomBinary();
    return (randomNumber == 0) ? "Male" : "Female";
  }
}
