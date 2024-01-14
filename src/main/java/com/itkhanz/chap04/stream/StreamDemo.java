package com.itkhanz.chap04.stream;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(-1, 0, 5, 4, 4, 4, 7, 8, 1, 2, 9, 3, 6);


    //4, 16, 64
    List<Integer> processedList = numbers.stream()
      .skip(2)                                               //skips the first two numbers i.e. -1 and 0
      .distinct()                                               //only chooses the unique numbers
      .filter(n -> n % 2 == 0)                                  //filter even numbers
      .sorted(Comparator.naturalOrder())                        //sorts the stream in natural order i.e. ascending
      .peek(n -> System.out.println("Filtered number: " + n))   //print filtered number for debugging
      .limit(3)                                         //limits the stream to max of 3 elements
      .map(n -> n * n)                                          //performs square of number
      .toList();                                               //collects the sorted stream to list
    ;


    //prints the list in parallel
    processedList.stream()
      .parallel()
      .forEach(n -> System.out.println("processed: " + n));


    //*************************************************************
    //find the min and max, and count of even numbers from list
    List<Integer> listOfFive= List.of(1, 2, 3, 4, 5);

    int max = listOfFive.stream()
      .max(Comparator.naturalOrder())
      .get();

    int min = listOfFive.stream()
      .min(Comparator.naturalOrder())
      .get();

    long countEven = listOfFive.stream()
      .filter(i -> i % 2 == 0)
      .count();

    System.out.printf("max: %d, min: %d, count: %d%n", max, min, countEven);


    //*************************************************************
    //find first or any even number from list
    Optional<Integer> firstEven = listOfFive.stream()
      .filter(i -> i % 2 == 0)
      .findFirst();

    Optional<Integer> anyEven = listOfFive.stream().parallel()
      .filter(i -> i % 2 == 0)
      .findAny();

    //conventional approach
    if(firstEven.isPresent()) {
      System.out.println("first even: " + firstEven.get());
    }
    anyEven.ifPresent(n -> System.out.println("any even: " + n)); //better approach with functional style


    //*************************************************************
    //checks if any element in the list is divisible by 4
    boolean anyMatchDivisbleBy4 = listOfFive.stream()
      .anyMatch(n -> n % 4 == 0);
    System.out.println("Found any matching divisible by 4: " + anyMatchDivisbleBy4);  //true

    //checks if none of the element in the list is divisible by 4
    boolean noneMatchDivisbleBy4 = listOfFive.stream()
      .noneMatch(n -> n % 4 == 0);
    System.out.println("Found none matching divisible by 4: " + noneMatchDivisbleBy4);  //false


    //*************************************************************
    //Nested List
    List<List<Integer>> listOfLists = Arrays.asList(
      Arrays.asList(1, 2, 3),
      Arrays.asList(4, 5),
      Arrays.asList(6, 7, 8)
    );

    //finds the sum of list => flatMap usage
    int sum = listOfLists.stream()
      .flatMap(Collection::stream) // Flatten the list of lists
      .mapToInt(Integer::intValue) // Convert to IntStream
      .sum(); // Calculate the sum

    System.out.println("Sum of all numbers: " + sum);  //36


    //*************************************************************
    //Stream utility methods
    //generate accepts a supplier using which it can keep calling to generate data.
    //However, the same can be achieved IntStream.range as well.
    List<Integer> listOf1s = Stream.generate(() -> 1)
      .limit(5)
      .toList();
    System.out.println("List of 1s: " + listOf1s);

    IntStream.range(1, 5)
      .forEach(i -> System.out.println("Hello world :: " + i)); //1 to 4



    //*************************************************************
    //Comparator - comparing
    Student a  = new Student("adam", 80, 150);
    Student b = new Student("bob", 96, 123);
    Student c = new Student("carl", 75, 180);

    Optional<Student> studentWithHighestMarks = Stream.of(a, b, c)
      .max(Comparator.comparing(Student::getScore));

    System.out.println(studentWithHighestMarks.get());



    //*************************************************************
    //Stream Reduce
    //Java internally converts reference type int to primitive type Integer
    //This operation can become expensive if the list contains million of numbers
    Integer total = listOfFive.stream()
      //.reduce(0, (n1,n2) -> n1+n2);
      .reduce(0, Integer::sum);
    System.out.println(total);



    //*************************************************************
    //Primitive Streams
    //IntStream is a primitive type stream that has all the methods like sum, average

    //sum
    List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
    int sum1 = myList.stream()
      .mapToInt(Integer::intValue)
      .sum();
    System.out.println("sum of list of 5: " + sum1);

    //avg
    OptionalDouble average = myList.stream()
      .mapToDouble(Integer::doubleValue)
      .average()
      ;
    double avg = average.isPresent() ? average.getAsDouble() : 0;
    System.out.println("avg of list of 5: " + avg);





  }

}
