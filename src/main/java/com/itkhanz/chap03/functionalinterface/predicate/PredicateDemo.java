package com.itkhanz.chap03.functionalinterface.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
  public static void main(String[] args) {

    Predicate<Integer> isGT2 = (num) -> num > 2;
    Predicate<Integer> isLT10 = (num) -> num < 10;

    //Test that number should be greater than 2 and less than 10
    System.out.println(
      isGT2.and(isLT10).test(5) //true
    );

    //test that number should not be less than 10
    System.out.println(
      isLT10.negate().test(5)  //false
    );
  }
}
