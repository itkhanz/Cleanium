package com.itkhanz.tests.assignment;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class FirstNameAssignment {

  public static void main(String[] args) {

    Path filePath = Paths.get(System.getProperty("user.dir") + "/src/test/resources/first-names.txt");
    Charset charset = StandardCharsets.UTF_8;
    try {
      List<String> namesList = Files.readAllLines(filePath, charset);

      //print the count of names which start with letter B
      long namesCount = namesList.stream()
        .filter(name -> name.startsWith("B"))
        .count();
      System.out.println("Count of names starting with letter B: " + namesCount);


      //create a list of names which start with letter C and contains 's' in it
      List<String> filteredList = namesList.stream()
        .filter(name -> name.startsWith("C") && name.contains("s"))
        .toList();
      System.out.println(filteredList.size());


      //print the total number of chars for all the names starting with M
      int charCount = namesList.stream()
        .filter(name -> name.startsWith("M"))
        .map(String::length)
        .mapToInt(Integer::intValue)
        .sum();
      System.out.println("total number of chars for all names starting with 'M': " + charCount);


      //Jo-Ann => Jo Ann
      //find the names containing '-', and replace with space ' ', and collect them into a list
      List<String> spacedNames = namesList.stream()
        .filter(name -> name.contains("-"))
        .map(name -> name.replaceAll("-", " "))
        .toList();
      System.out.println("replaced '-' with ' ' names: " + spacedNames);


      //find the name which has more number of chars
      namesList.stream()
        .max(Comparator.comparing(String::length))
        .ifPresent(System.out::println);

    } catch (IOException ex) {
      System.out.format("I/O error: %s%n", ex);
    }

  }
}
