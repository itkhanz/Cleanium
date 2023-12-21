package com.itkhanz.demos.part04;

public class LogImpl {
  public static void main(String[] args) {

    ILoggable logger = () -> System.out.println("abstract log method");
    logger.log();
    //logger.scan() //not possible as functional interface can have only one abstract method

    //default method
    logger.log_info();

    //static method
    ILoggable.log_error();

  }
}
