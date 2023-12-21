package com.itkhanz.demos.part08.usecase3;

/**
 * Dummy Class representing the Extent Report Logger
 */
class ReportManager {

  public static void error(String message) {
    System.out.println("ERROR: " + message);
  }

  public static void warn(String message) {
    System.out.println("WARN: " + message);
  }

  public static void debug(String message) {
    System.out.println("DEBUG: " + message);
  }

  public static void info(String message) {
    System.out.println("INFO: " + message);
  }

}
