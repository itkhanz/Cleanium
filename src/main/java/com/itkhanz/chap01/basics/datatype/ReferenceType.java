package com.itkhanz.chap01.basics.datatype;

import java.util.Arrays;

public class ReferenceType {
  public static void main(String[] args) {

    int[] arr = new int[] {1, 2, 3};

    //In real life scenarios, there could be hundreds of methods that could possibly manipulate the original array
    //This will result in wrong values for calculation of next totalSale
    predict(arr);

    totalSale(arr);

  }


  private static void predict(int[] a) {
    //we can avoid mutation by create a new array and perform operations on it so original array stays unchanged
    a = Arrays.copyOf(a, a.length);

    a[0]++;
    a[1]++;
    System.out.println("Prediction for next month :: " + (a[0] + a[1] + a[2])); //8
  }

  private static void totalSale(int[] a) {
    System.out.println("Total Sale for this month :: " + (a[0] + a[1] + a[2])); //6
  }
}
