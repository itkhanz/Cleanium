package com.itkhanz.java10;

import java.util.List;
import java.util.Map;

public class VarDemo {
  public static void main(String[] args) {

    //Local Type Inference
    var num = 10;
    var nums = List.of(1,2,3,4,5);
    var studentMarks = Map.of("tom", 10, "jack", 20);

    //*********** Limitations *************************
    //In order to use var, java has to know the type from right hand side
    //It can only be used inside the method
    //It cannot be null
    //It cannot be return type of method, or method parameter
    //It cannot be used as functional interface type => lambda declaration
    //It cannot be used with generics like new ArrayList<>(), the type must be specified in diamond brackets
    //*************************************************

    //var is not a keyword (reserve)


  }
}
