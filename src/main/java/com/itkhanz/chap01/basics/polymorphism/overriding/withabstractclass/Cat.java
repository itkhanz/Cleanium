package com.itkhanz.chap01.basics.polymorphism.overriding.withabstractclass;

public class Cat extends Animal{
  @Override
  public void makeSound(){
    System.out.println("I am cat. meow....");
  }
}
