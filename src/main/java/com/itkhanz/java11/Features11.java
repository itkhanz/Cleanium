package com.itkhanz.java11;

public class Features11 {
  public static void main(String[] args) {
    String name = " ";

    System.out.println(name.isEmpty()); //false

    //considers whitespaces also as empty
    System.out.println(name.isBlank()); //true

    System.out.println("hello".repeat(5));  //appends hello 5 times

    //remove white spaces
    String course = " java ";

    System.out.println("::"+ course + "::");
    System.out.println("::"+ course.trim() + "::");

    char c = '\u2002';
    String city = c + " berlin " + c;
    System.out.println("::"+ city.strip() + "::");
    System.out.println("::"+ city.stripLeading() + "::");
    System.out.println("::"+ city.stripTrailing() + "::");
  }
}
