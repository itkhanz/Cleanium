package com.itkhanz.demos.part06;

/**
 * Generic functional interface that accepts two generic arguments T and U, and return R
 * This is similar to in-built Function interface
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface IAdder<T, U, R> {
  public abstract  R add(T t, U u);

  /**
   * Problem here is that you cannot keep on creating interfaces if you have different requirements:
   * accepts 1 parameter and return nothing
   * accepts 2 parameters and return something
   * accepts no parameter and return boolean
   * To solve this problem, Java provides Package java.util.function
   */
}
