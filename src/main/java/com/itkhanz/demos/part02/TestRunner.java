package com.itkhanz.demos.part02;

public class TestRunner {
  public static void main(String[] args) {

    //Traditional approach
    IPrintable printer = new ConsolePrinterImpl();
    printer.print();

    //If the only purpose of ConsolePrinterImpl class is to override the print() method then we dont need to create separate class
    //we can achieve this using anonymous inner class by creating a definition for interface at the time of initialization
    //This class exists inside another class and does not have any name so it is called anonymous inner class
    //It forms the basis for functional programming
    IPrintable printer2 = new IPrintable() {
      @Override
      public void print() {
        System.out.println("Printing from Anonymous Inner Class");
      }
    };
    printer2.print();

  }
}
