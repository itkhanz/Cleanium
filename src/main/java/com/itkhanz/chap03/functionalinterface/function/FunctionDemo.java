package com.itkhanz.chap03.functionalinterface.function;

import java.util.function.Function;

public class FunctionDemo {
  public static void main(String[] args) {
    Function<Integer, Integer> add = (n) -> n + n;
    Function<Integer, Integer> square = (n) -> n * n;

    //first performs add(2+2), and then square the result 4*4
    System.out.println(
      add.andThen(square).apply(2) //16
    );

    //first performs square (2*2), and then add the result 4+4
    System.out.println(
      add.compose(square).apply(2)  //8
    );

  }
}
