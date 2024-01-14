package com.itkhanz.chap04.stream;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
  public static void main(String[] args) {
    List<String> fruits = List.of(
      "apple",
      "apple",
      "banana",
      "orange",
      "mango",
      "pineapple",
      "cherry",
      "kiwi"
    );

    //Collector - toList
    List<String> appleList = fruits.stream()
      .filter(fruit -> fruit.contains("apple"))
      .collect(Collectors.toList());
    System.out.println("List of apples: " + appleList); //[apple, apple, pineapple]


    //Collector - toSet
    //Set does not preserve the order, allows distinct values, higher performance compared to list
    Set<String> appleSet = fruits.stream()
      .filter(fruit -> fruit.contains("apple"))
      .collect(Collectors.toSet());
    System.out.println("Set of apples: " + appleSet); //[apple, pineapple]


    //Collector - joining
    String fullName = Stream.of("t", "o", " ", "m")
      .filter(str -> !str.isBlank())
      .collect(Collectors.joining());
    System.out.println(fullName); //tom


    //Collector - groupingBy

    //groupingBy Usage with list
    Map<Character,List<String>> groupByStartingAlphabet = fruits.stream()
      .collect(Collectors.groupingBy(fruit -> fruit.charAt(0)));

    System.out.println(groupByStartingAlphabet);  //{p=[pineapple], a=[apple, apple], b=[banana], c=[cherry], k=[kiwi], m=[mango], o=[orange]}


    //groupingBy Usage with Map
    Map<String, String> students = Map.ofEntries(
      Map.entry("tom", "male"),
      Map.entry("jack", "male"),
      Map.entry("anna", "female"),
      Map.entry("harry", "male"),
      Map.entry("sara", "female")
    );

    //The groupingBy method is used to group the entries by their values (in this case, gender).
    //The mapping method is used to transform each entry in the group to just the key (the student's name) and then collect these names into a list.
    //The result is a Map<String, List<String>>, where each key is a gender, and the corresponding value is a list of names of students of that gender.

    Map<String, List<String>> groupedByGender = students.entrySet()
      .stream()
      .collect(Collectors.groupingBy(
        Entry::getValue,
        Collectors.mapping(Entry::getKey, Collectors.toList())
      ));

    System.out.println(groupedByGender);  //{female=[anna, sara], male=[harry, jack, tom]}



  }
}
