package com.itkhanz.designpatterns.proxy.components.order;

import com.itkhanz.designpatterns.proxy.enums.Environment;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderProxy implements Order{
  private static final List<String> EXCLUDED = Arrays.asList(Environment.STAGING.getValue(), Environment.PROD.getValue());
  private OrderImpl orderComponent;

  public OrderProxy(WebDriver driver){
    String currentEnv = System.getProperty("env"); // DEV / QA / PROD / STAGING
    if(!EXCLUDED.contains(currentEnv)){
      this.orderComponent = new OrderImpl(driver);
    }
  }

  @Override
  public String placeOrder() {
    if(Objects.nonNull(this.orderComponent)){
      return this.orderComponent.placeOrder();
    }else{
      return "SKIPPED";
    }
  }
}
