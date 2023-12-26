package com.itkhanz.nopcommerce.utils.faker;

/*
Abstracts the internals of FakerFactory and provides an API to end user to get fake data
Later even if the internals of FakerFactory got changed, the api to get the fake data by end user via FakerService will not be impacted
 */
public class FakerService {
  public static String getEmail() {
    return FakerFactory.getEmail();
  };

  public static String getPassword() {
    return FakerFactory.getPassword();
  }
}
