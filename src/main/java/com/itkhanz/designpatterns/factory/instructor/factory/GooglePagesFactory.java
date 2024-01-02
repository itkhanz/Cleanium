package com.itkhanz.designpatterns.factory.instructor.factory;

import com.itkhanz.designpatterns.factory.instructor.pages.Google.GoogleESPage;
import com.itkhanz.designpatterns.factory.instructor.pages.Google.GoogleEnglishPage;
import com.itkhanz.designpatterns.factory.instructor.pages.Google.GoogleFrenchPage;
import com.itkhanz.designpatterns.factory.instructor.pages.Google.GooglePage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
public class GooglePagesFactory {
  private static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglishPage(d);
  private static final Function<WebDriver, GooglePage> FR = (d) -> new GoogleFrenchPage(d);
  private static final Function<WebDriver, GooglePage> ES = (d) -> new GoogleESPage(d);
  private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

  static {
    MAP.put("ENG", ENG);
    MAP.put("FR", FR);
    MAP.put("ES", ES);
  }

  public static GooglePage get(String language, WebDriver driver){
    return MAP.get(language).apply(driver);
  }
}
