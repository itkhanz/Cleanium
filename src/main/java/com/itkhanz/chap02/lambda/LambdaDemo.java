package com.itkhanz.chap02.lambda;

import java.util.Objects;

public class LambdaDemo {
  public static void main(String[] args) {

    //conventional way
    /*GreetingService greetingService = new GreetingService() {
      @Override
      public String greet(String firstName) {
        return "Hello " + firstName.toUpperCase();
      }
    };*/

    //*******************************************
    //Lambda expression allows us to remove the implementation using functional programming, and compiler will automatically treat it as implementation of abstract method
    //For an interface to be treated as functional interface, it must only have one abstract method
    //single line lambda does not require braces
    GreetingService helloService = firstName -> "Hello " + firstName.toUpperCase();
    GreetingService hiService = firstName -> "Hi " + firstName.toUpperCase();

    System.out.println(helloService.greet("tom"));
    System.out.println(hiService.greet("tom"));

    //*******************************************
    //Multi-line lambda with multiple parameters
    StringOperations nameOperations = (firstName, lastName) -> {
      System.out.println(firstName.toUpperCase());
      System.out.println(lastName.toLowerCase());
      return "Full Name: " + firstName + lastName;
    };

    nameOperations.printFullName("harry", "rich");

    //*******************************************
    //Higher Order Function
    //Pass function (behavior) as method parameter
    //GreetingService greetingService = str -> str.toUpperCase() + str.toLowerCase();
    //testHigherOrderFn(greetingService);
    testHigherOrderFn(str -> str.toUpperCase() + str.toLowerCase());

    //A higher order function can also return lambda
    GreetingService greetingService = getGreeting();
    System.out.println(greetingService.greet("bill"));;

    //*******************************************
    //Method reference
    //BooleanOperations operation = str -> Objects.isNull(str);
    BooleanOperations operation = Objects::isNull;
    System.out.println(operation.accept("abc"));

    //Multi parameter method reference
    //StringOperations stringOperations = (a, b) -> a.concat(b);
    StringOperations stringOperations = String::concat;
    System.out.println(stringOperations.printFullName("tom", "jerry"));

  }

  private static void testHigherOrderFn(GreetingService service) {
    System.out.println(service.greet("tom"));
  }

  private static GreetingService getGreeting() {
    return str -> str.toUpperCase() + str.length();
  }
}
