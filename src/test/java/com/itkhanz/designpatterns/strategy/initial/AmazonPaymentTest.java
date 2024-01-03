package com.itkhanz.designpatterns.strategy.initial;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.strategy.initial.enums.PaymentMethod;
import com.itkhanz.designpatterns.strategy.initial.factory.PaymentComponentFactory;
import com.itkhanz.designpatterns.strategy.initial.factory.PaymentInfoFactory;
import com.itkhanz.designpatterns.strategy.initial.pages.OrderPage;
import com.itkhanz.designpatterns.strategy.initial.pages.components.PaymentComponent;
import com.itkhanz.designpatterns.strategy.initial.pojos.PaymentInfo;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonPaymentTest extends BaseTest {

  @Test(dataProvider = "getPaymentMethod")
  public void test_order_confirmation(PaymentMethod paymentMethod) {

    PaymentComponent paymentComponent = PaymentComponentFactory.getPaymentComponent(paymentMethod, driver);
    PaymentInfo paymentInfo = PaymentInfoFactory.getPaymentInfo(paymentMethod);

    String orderNumber = OrderPage.withPaymentComponent(paymentComponent, driver)
                          .open()
                          .fillPersonalInfo("abc", "def", "test@test.com")
                          .fillPaymentInfo(paymentInfo)
                          .placeOrder()
                          .getOrderID();

    System.out.println(orderNumber);
    Assertions.assertThat(orderNumber).isNotNull();
  }

  @DataProvider
  private Object[][] getPaymentMethod() {
    return new Object[][] {
      {PaymentMethod.CREDIT_CARD},
      {PaymentMethod.NET_BANKING},
      {PaymentMethod.PAYPAL}
    };
  }
}
