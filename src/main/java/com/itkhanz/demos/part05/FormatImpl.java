package com.itkhanz.demos.part05;

public class FormatImpl {
  public static void main(String[] args) {

    IFormatter formatter = (firstName, lastName) -> firstName + " " +  lastName;

    System.out.println(formatter.format("paul", "david"));
  }
}
