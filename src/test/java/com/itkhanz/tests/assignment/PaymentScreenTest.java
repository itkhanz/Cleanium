package com.itkhanz.tests.assignment;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.function.Consumer;

public class PaymentScreenTest {
  private WebDriver driver;
  private PaymentScreenPage paymentScreenPage;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
    this.paymentScreenPage = new PaymentScreenPage(driver);
  }

  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }


  @Test(dataProvider = "criteriaProvider")
  public void payment_methods_test(Consumer<PaymentScreenPage> paymentAction, String status) {
    paymentScreenPage.goTo();

    paymentAction.accept(paymentScreenPage);

    paymentScreenPage.buyProduct();
    Assert.assertEquals(paymentScreenPage.getStatus(), status);
  }

  @DataProvider(name = "criteriaProvider")
  public Object[][] testdata() {
    //actions
    final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
    final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
    final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
    final Consumer<PaymentScreenPage> invalidCC = (p) -> p.enterCC("4111111111111112", "2023", "123");
    final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

    return new Object[][] {
      { validCC.andThen(buy), "PASS" },
      { freeCoupon.andThen(buy), "PASS" },
      { discountedCoupon.andThen(validCC).andThen(buy), "PASS" },
      { invalidCC.andThen(buy), "FAIL" },
      { invalidCC.andThen(discountedCoupon).andThen(buy), "FAIL" },
      { buy, "FAIL" }
    };
  }
}
