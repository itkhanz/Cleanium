package com.itkhanz.demos.part06;

public class GenericFunctionalInterface {
  public static void main(String[] args) {

    //first two parameters are input, third is output

    IAdder<String, String, String> stringAdder = (firstName, lastName) -> firstName + " " + lastName;
    System.out.println(stringAdder.add("tom", "david"));

    IAdder<Integer, Integer, Integer> intAdder = (num1, num2) -> num1 + num2;
    System.out.println(intAdder.add(2,3));
  }
}
