package com.itkhanz.demos.part05;

@FunctionalInterface
public interface IFormatter {

  /**
  * The problem with this approach is that, if we want to create more methods with different parameters or return types
  * then we must create separate functional interfaces. This is quite tedious. For this purpose, Java provides some in-built functional interfaces.
  */
  String format(String firstName, String lastName);

}
