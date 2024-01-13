package com.itkhanz.chap03.functionalinterface.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;


class Calculator {

  private static BiFunction<Integer, Integer, Integer> add = Integer::sum;
  private static BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
  private static BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
  private static BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;

  private static final Map<String, BiFunction<Integer, Integer, Integer>> OP_MAP = new HashMap<>();
  static {
    OP_MAP.put("+", add);
    OP_MAP.put("-", subtract);
    OP_MAP.put("*", multiply);
    OP_MAP.put("/", divide);
  }

  public static void main(String[] args) {
    System.out.println(calculate("5 + 2 - 3 * 7 + 2 / 3"));   //10
    System.out.println(calculate("10 / 2 * 3 - 3 / 3 * 5"));  //20
    System.out.println(calculate("9 * 9 - 1 * 7 / 8 + 30"));  //100
  }

  /*
  Assumptions:valid expression starting and ending with integer, space-separated, no division by 0
   */
  private static int calculate(String expression) {
    List<String> digitsOpsList = Arrays.stream(expression.split(" ")).toList();

    // Initialize the result with the first number
    int result = Integer.parseInt(digitsOpsList.get(0));
    int enteredNum;
    BiFunction<Integer, Integer, Integer> mathOperation;

    for (int i = 0; i < digitsOpsList.size() - 2; i += 2) {
      enteredNum = Integer.parseInt(digitsOpsList.get(i + 2));

      // Get the corresponding math operation from the map
      mathOperation = OP_MAP.get(digitsOpsList.get(i+1));

      // Apply the math operation and update the result
      result = mathOperation.apply(result, enteredNum);
    }

    return result;
  }
}
