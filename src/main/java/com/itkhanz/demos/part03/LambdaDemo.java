package com.itkhanz.demos.part03;

import com.itkhanz.demos.part02.ConsolePrinterImpl;
import com.itkhanz.demos.part02.IPrintable;

public class LambdaDemo {
  public static void main(String[] args) {
    //Conventional approach
    IPrintable printer = new ConsolePrinterImpl();
    printer.print();

    //Anonymous Inner Class
    IPrintable printer2 = new IPrintable() {
      @Override
      public void print() {
        System.out.println("Printing from Anonymous Inner Class");
      }
    };
    printer2.print();

    //Functional Programming
    //Since Java 8, compilers are smart enough to assume the interface implementation so we not need to explicitly mentions new IPrintable
    //As ConsolePrinterImpl() class have only one method and that method is abstract, we can write it using lambda,
    // and compiler will treat it as implementation of abstract print() method in IPrintable interface
    IPrintable printer3 = () -> System.out.println("printing from lambda experession");
    printer3.print();
  }
}
