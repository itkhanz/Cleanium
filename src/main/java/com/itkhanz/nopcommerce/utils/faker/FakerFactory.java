package com.itkhanz.nopcommerce.utils.faker;

import com.github.javafaker.Faker;

class FakerFactory {
  private final static Faker faker = new Faker();

  public static String getEmail() {
    return faker.internet().emailAddress();
  }

  public static String getPassword() {
    return faker.internet().password();
  }

  public static String getFirstName() {
    return faker.name().firstName();
  }

  public static String getLastName() {
    return faker.name().lastName();
  }

  public static String getFullName() {
    return faker.name().fullName();
  }

  public static String getAddress() {
    return faker.address().fullAddress();
  }

  public static String getStreet() {
    return faker.address().streetAddress();
  }

  public static String getCity() {
    return faker.address().cityName();
  }

  public static String getPostCode() {
    return faker.address().zipCode();
  }

  public static String getCountry() {
    return faker.address().country();
  }

  public static String getPhone() {
    return faker.phoneNumber().phoneNumber();
  }
}
