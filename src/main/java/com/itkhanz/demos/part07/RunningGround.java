package com.itkhanz.demos.part07;

import java.util.function.Consumer;

public class RunningGround {
  static void perform(IAnimal animal) {
    animal.run();
  }

  public static void main(String[] args) {

    //************* Example 01 ********************
    //conventional approach -> passing object that wraps a behavior
    IAnimal cat = new Cat();
    perform(cat);

    //Modern approach -> since Java 8 we can pass behavior as a method parameter
    perform(() -> System.out.println("running at 60 kmh"));


    //************* Example 02 ********************
    //Conventional approach => creating separate methods for each operation
    toUpper("Tom");
    toLower("Tom");
    printLength("Tom");

    //Functional approach => create a single method that accepts behavior as consumer
    stringOperation(s -> System.out.println(s.toLowerCase()), "Harry");
    stringOperation(s -> System.out.println(s.toUpperCase()), "Harry");
    stringOperation(s -> System.out.println(s.length()), "Harry");

  }

  private static void stringOperation(Consumer<String> op, String str) {
    op.accept(str);
  }

  private static void toUpper(String str) {
    System.out.println(str.toUpperCase());
  }

  private static void toLower(String str) {
    System.out.println(str.toLowerCase());
  }

  private static void printLength(String str) {
    System.out.println(str.length());
  }
}
