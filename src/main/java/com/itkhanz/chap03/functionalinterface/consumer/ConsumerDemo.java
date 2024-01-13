package com.itkhanz.chap03.functionalinterface.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {

  public static void main(String[] args) {
    Consumer<String> printCapitalizeName = (name) -> System.out.println(name.toUpperCase());

    printCapitalizeName.accept("tom");
  }

}
