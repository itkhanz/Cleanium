package com.itkhanz.designpatterns.decorator.amazon;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import com.itkhanz.designpatterns.BaseTest;

import static com.itkhanz.designpatterns.decorator.amazon.PaymentDecorator.*;

public class PaymentScreenTest extends BaseTest {
  private PaymentScreenPage paymentScreenPage;

  @BeforeMethod
  public void setPaymentScreenPage(){
    this.paymentScreenPage = new PaymentScreenPage(driver);
  }

  @Test(dataProvider = "getData")
  public void paymentScreenTest(Consumer<PaymentScreenPage> paymentValidation) {
    paymentScreenPage.goTo();
    paymentValidation.accept(paymentScreenPage);

    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
  }

  @DataProvider
  public Object[] getData(){
    return new Object[]{
      validCC.andThen(buy).andThen(successfulPurchase),
      freeCoupon.andThen(buy).andThen(successfulPurchase),
      discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
      invalidCC.andThen(buy).andThen(failedPurchase),
      invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
      buy.andThen(failedPurchase)
    };
  }

}
