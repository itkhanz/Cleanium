package com.itkhanz.designpatterns.strategy.instructor.amazon;

import com.google.common.util.concurrent.Uninterruptibles;
import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.strategy.instructor.Amazon.factory.PaymentOptionFactory;
import com.itkhanz.designpatterns.strategy.instructor.Amazon.pages.PaymentScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {
  private PaymentScreen paymentScreen;

  @BeforeMethod
  public void setPaymentScreen(){
    this.paymentScreen = new PaymentScreen(this.driver);
  }

  @Test(dataProvider = "getData")
  public void paymentTest(String option, Map<String, String> paymentDetails){
    this.paymentScreen.goTo();
    this.paymentScreen.getUserInformation().enterDetails("vinoth", "selvaraj", "udemy@gmail.com");
    this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
    this.paymentScreen.pay(paymentDetails);
    String orderNumber = this.paymentScreen.getOrder().placeOrder();

    System.out.println(
      "Order Number : " + orderNumber
    );

    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

  }

  @DataProvider
  public Object[][] getData(){

    Map<String, String> cc = new HashMap<>();
    cc.put("cc", "1231231231");
    cc.put("year", "2023");
    cc.put("cvv", "123");

    Map<String, String> nb = new HashMap<>();
    nb.put("bank", "WELLS FARGO");
    nb.put("account", "myaccount123");
    nb.put("pin", "999");

    return new Object[][]{
      {"CC", cc} ,
      {"NB", nb}
    };
  }
}
