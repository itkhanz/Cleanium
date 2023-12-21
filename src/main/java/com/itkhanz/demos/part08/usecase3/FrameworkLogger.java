package com.itkhanz.demos.part08.usecase3;

import java.util.Map;
import java.util.function.Consumer;

/**
 * This class is designed using Functional interfaces and allows us to extend the logging functionality by adding different consumers
 * User does not have to worry about the underlying implementation, they just call the FrameworkLogger.log(LogType, message)
 * Actual Implementation: https://github.com/amuthansakthivel/SeleniumAutomationFramework_Youtube/blob/main/src/main/java/com/tmb/reports/FrameworkLogger.java
 */
class FrameworkLogger {
  private FrameworkLogger() {}

  private static Consumer<String> ERROR = (message) -> ReportManager.error(message);
  private static Consumer<String> WARN = (message) -> ReportManager.warn(message);
  private static Consumer<String> DEBUG = (message) -> ReportManager.debug(message);
  private static Consumer<String> INFO = (message) -> ReportManager.info(message);
  private static Consumer<String> CONSOLE = (message) -> System.out.println("INFO-----> " + message);
  private static Consumer<String> LOGANDCONSOLE = INFO.andThen(CONSOLE);

  //Conventional way of initializing Map
  /*private static Map<LogType, Consumer<String>> logMap = new HashMap<>();
  static {
    logMap.put(LogType.ERROR, ERROR);
    logMap.put(LogType.WARN, WARN);
    logMap.put(LogType.DEBUG, DEBUG);
    logMap.put(LogType.INFO, INFO);
    logMap.put(LogType.LOGANDCONSOLE, LOGANDCONSOLE);
  }*/

  //Java 9 introduced a similar API, Map.ofEntries, which returns an unmodifiable or immutable map,
  // but this Map has no limit of the Map entry unlike Map.of, and we can create as many entries as we want.
  private static Map<LogType, Consumer<String>> logMap = Map.ofEntries(
    Map.entry(LogType.ERROR, ERROR),
    Map.entry(LogType.WARN, WARN),
    Map.entry(LogType.DEBUG, DEBUG),
    Map.entry(LogType.INFO, INFO),
    Map.entry(LogType.CONSOLE, CONSOLE),
    Map.entry(LogType.LOGANDCONSOLE, LOGANDCONSOLE)
  );

  //Call this method in your framework code to log the desired info
  public static void log(LogType status, String message) {
    logMap.get(status).accept(message);
  }
}
