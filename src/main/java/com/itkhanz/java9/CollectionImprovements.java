package com.itkhanz.java9;

import java.util.*;

public class CollectionImprovements {
  public static void main(String[] args) {

    //***************************************************
    //Immutable List
    //***************************************************
    //approach 01
   /*List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);*/

    //approach 02
    //List<Integer> numbers = new ArrayList<>();
    //Collections.addAll(numbers, 1,2,3,4,5);

    //Approach 03
    //List<Integer> numbers = Arrays.asList(1,2,3,4,5);

    //Java 09
    //It does not allow null values, and the list is immutable
    List<Integer> numbers = List.of(1,2,3,4,5);


    //***************************************************
    //Immutable Set
    //***************************************************
    Set<String> names = Set.of("ab", "bc", "cd");


    //***************************************************
    //Immutable Map
    //***************************************************
    // this works for up to 10 elements:
    Map<String, String> test1 = Map.of(
      "a", "b",
      "c", "d"
    );

    // this works for any number of elements:
    Map<String, String> test2 = Map.ofEntries(
      Map.entry("a", "b"),
      Map.entry("c", "d")
    );

  }
}
