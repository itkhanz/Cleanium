package com.itkhanz.chap03.functionalinterface.supplier;

import java.util.function.Supplier;

public class SupplierDemo {

  public static void main(String[] args) {
    //Supplier<Double> randomNumSupplier = () -> Math.random();
    Supplier<Double> randomNumSupplier = Math::random;
    System.out.println(randomNumSupplier.get());
  }

}
