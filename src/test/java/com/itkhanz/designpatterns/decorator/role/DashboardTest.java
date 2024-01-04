package com.itkhanz.designpatterns.decorator.role;

import com.itkhanz.designpatterns.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardTest extends BaseTest {

  private DashboardPage dashboardPage;

  @BeforeMethod
  public void setDashboardPage(){
    this.dashboardPage = new DashboardPage(driver);
  }

  @Test(dataProvider = "getData")
  public void roleTest(Consumer<DashboardPage> roleComponentsValidation){
    this.dashboardPage.goTo();
    roleComponentsValidation.accept(this.dashboardPage);
  }

  @DataProvider
  public Object[] getData(){
    return new Object[]{
      RoleDecorator.guestComponentsValidation,
      RoleDecorator.superComponentsValidation,
      RoleDecorator.adminComponentsValidation
    };
  }



}
