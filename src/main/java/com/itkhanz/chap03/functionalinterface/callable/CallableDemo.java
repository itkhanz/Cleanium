package com.itkhanz.chap03.functionalinterface.callable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallableDemo {
  public static void main(String[] args) {

    //Supplier
    Supplier<Double> randomNumSupplier = Math::random;
    System.out.println(randomNumSupplier.get());

    //Callable call must be called with exception handling mechanism
    Callable<Double> randomNumCaller = Math::random;
    try {
      System.out.println(randomNumCaller.call());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
