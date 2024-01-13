package com.itkhanz.chap02.lambda.assignment;

class Calculator {

  public static void main(String[] args) {
    MathOperation add = Integer::sum;
    MathOperation subtract = (a, b) -> a - b;
    MathOperation multiply = (a, b) -> a * b;
    MathOperation divide = (a, b) -> a / b;

    //Test Data: 5 + 2 - 3 * 7 + 2 / 3
    int onScreenNum = 0;
    onScreenNum = calculate(onScreenNum, add, 5);
    onScreenNum = calculate(onScreenNum, add, 2);
    onScreenNum = calculate(onScreenNum, subtract, 3);
    onScreenNum = calculate(onScreenNum, multiply, 7);
    onScreenNum = calculate(onScreenNum, add, 2);
    onScreenNum = calculate(onScreenNum, divide, 3);
    System.out.println(onScreenNum);
  }

  private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber) {
    return mathOperation.operate(onScreenNumber, enteredNumber);
  }
}
