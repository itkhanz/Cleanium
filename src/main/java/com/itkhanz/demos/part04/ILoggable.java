package com.itkhanz.demos.part04;

//Add @FunctionalInterface annotation to let others know that this interface is to be used as lambda
@FunctionalInterface
public interface ILoggable {
  void log();

  /*
  You can have more than one default and static methods in an interface
  But you cannot have more than one abstract methods inside an interface if you want to use it as Lambda
  Either you remove the @FunctionalInterface annotation or this scan() method
  void scan();
  */

  default void log_info() {
    System.out.println("Default method");
  }

  static void log_error() {
    System.out.println("Static method");
  }
}
