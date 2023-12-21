package com.itkhanz.demos.part08.usecase5;

import java.util.Map;

class MapIteration {
  public static void main(String[] args) {
    Map<Integer, String> apiOperations = Map.of(
      1, "create",
      2, "read",
      3, "update",
      4, "delete"
    );

    //Approach 01
    for (Map.Entry<Integer, String> entry : apiOperations.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    //Approach 02 -> forEach accepts BiConsumer
    apiOperations.forEach((key, value) -> System.out.println(key + " : " + value));
  }
}
