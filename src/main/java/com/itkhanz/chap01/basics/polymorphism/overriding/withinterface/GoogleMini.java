package com.itkhanz.chap01.basics.polymorphism.overriding.withinterface;

public class GoogleMini implements HasAlarm {
  public void ask(){
    System.out.println("Hows the weather outside?");
  }

  public void setAlarm(){
    System.out.println("Google Mini - Setting an alarm @7:30AM");
  }
}
