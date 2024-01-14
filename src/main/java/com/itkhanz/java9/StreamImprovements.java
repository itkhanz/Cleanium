package com.itkhanz.java9;

import java.util.List;
import java.util.stream.Collectors;

public class StreamImprovements {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(2, 1, 4, 5, 2, 1, 1, 3, 5, 5);

    //processes the entire list
    //[2, 1, 4, 2, 1, 1, 3]
    System.out.println(
      numbers.stream()
        .filter(n -> n<5)
        .collect(Collectors.toList())
    );

    //exits the stream when the condition in takeWhile() fails
    //[2, 1, 4]
    System.out.println(
      numbers.stream()
        .takeWhile(n -> n<5)
        .collect(Collectors.toList())
    );

    //skips the stream until condition in dropWhile() is passed
    //[5, 2, 1, 1, 3, 5, 5]
    System.out.println(
      numbers.stream()
        .dropWhile(n -> n<5)
        .collect(Collectors.toList())
    );

  }
}
