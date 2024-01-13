package com.itkhanz.chap03.functionalinterface.runnable;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class RunnableDemo {
  public static void main(String[] args) {
    Runnable printPersonName = () -> {
      Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
      System.out.println("tom");
    };

    //This will execute in a separate thread and prints the name after Hi
    new Thread(printPersonName).start();

    System.out.println("Hi");
  }
}
