package com.itkhanz.chap01.basics.polymorphism.overriding.withabstractclass;

public abstract class Animal {
  private String name;

  public void makeSound(){
    System.out.println("I am animal.. Grrrrr.....");
  }

  public void walk(){
    System.out.println("I am walking");
  }
}
