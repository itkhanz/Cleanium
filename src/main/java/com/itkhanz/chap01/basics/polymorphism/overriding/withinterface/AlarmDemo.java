package com.itkhanz.chap01.basics.polymorphism.overriding.withinterface;

public class AlarmDemo {
  public static void main(String[] args) {

    GoogleMini googleMini = new GoogleMini();
    IPhone iPhone = new IPhone();
    Clock clock = new Clock();

    //We accept interface as argument to the alarmTest() to achieve runtime polymorphism
    alarmTest(googleMini);
    alarmTest(iPhone);
    alarmTest(clock);
  }

  private static void alarmTest(HasAlarm alarm) {
    alarm.setAlarm();
  }
}
