package com.itkhanz.chap01.basics.polymorphism.overloading;

public class Calculator {
  public static void main(String[] args) {
    AreaCalculator calculator = new AreaCalculator();

    //compile time polymorphism
    System.out.println(calculator.getArea(5));
    System.out.println(calculator.getArea(5.5));
    System.out.println(calculator.getArea(5,10));
    System.out.println(calculator.getArea(5.5,10));
  }
}
