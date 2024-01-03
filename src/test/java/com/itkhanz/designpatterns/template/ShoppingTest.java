package com.itkhanz.designpatterns.template;

import com.itkhanz.designpatterns.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Supplier;

public class ShoppingTest extends BaseTest {

  @Test(dataProvider = "getData")
  public void shoppingTest(Supplier<ShoppingTemplate> shoppingTemplate){
    shoppingTemplate.get().shop();
  }


  @DataProvider
  public Object[][] getData(){
    Supplier<ShoppingTemplate> ebayShopping = () -> new EBayShopping(driver, "samsung 4k");
    Supplier<ShoppingTemplate> opencartShopping = () -> new OpenCartShopping(driver, "macbook");

    return new Object[][]{
      { ebayShopping },
      { opencartShopping }
    };
  }
}
