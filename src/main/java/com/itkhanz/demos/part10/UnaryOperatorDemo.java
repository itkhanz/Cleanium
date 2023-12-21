package com.itkhanz.demos.part10;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class UnaryOperatorDemo {


  /*
  Print sum of all numbers in an array or list
   */
  @Test
  public void binaryOperatorTest() {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

    //Approach 01
    System.out.println(numbers.parallelStream().mapToInt(Integer::intValue).sum());

    //Approach 02
    System.out.println(numbers.parallelStream().reduce(0, (a,b) -> a + b));

    //Approach 03
    System.out.println(numbers.parallelStream().reduce(0, Integer::sum));
  }
}
