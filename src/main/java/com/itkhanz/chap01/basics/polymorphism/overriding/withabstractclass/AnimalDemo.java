package com.itkhanz.chap01.basics.polymorphism.overriding.withabstractclass;

public class AnimalDemo {
  public static void main(String[] args) {
    //We use the abstract class Animal and reuse the test() method with different implementations of Animal
    Animal cat = new Cat();
    Animal dog  = new Dog();

    test(cat);

    test(dog);
  }

  private static void test(Animal animal) {
    animal.makeSound();
    animal.walk();
  }
}
