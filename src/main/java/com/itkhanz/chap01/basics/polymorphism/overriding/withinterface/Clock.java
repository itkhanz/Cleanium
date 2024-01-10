package com.itkhanz.chap01.basics.polymorphism.overriding.withinterface;

import java.time.LocalDateTime;

public class Clock implements HasAlarm {
  public void showTime(){
    System.out.println("It is " + LocalDateTime.now());
  }

  public void setAlarm(){
    System.out.println("Clock - Setting an alarm @7:30AM");
  }
}
