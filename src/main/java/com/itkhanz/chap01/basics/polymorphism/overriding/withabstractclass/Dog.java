package com.itkhanz.chap01.basics.polymorphism.overriding.withabstractclass;

public class Dog extends Animal{
  @Override
  public void makeSound(){
    System.out.println("I am dog. barking....");
  }
}
