package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;
import com.itkhanz.nopcommerce.pages.components.submenus.LeftMenuComponent;
import com.itkhanz.nopcommerce.pages.customer.CustomersPage;
import org.openqa.selenium.By;

public class DashboardPage implements HasAlerts {

  private static final By dashboardHeading = By.xpath("//h1[normalize-space() = 'Dashboard']");

  private final LeftMenuComponent leftMenuComponent;
  private final CustomersPage customersPage;

  public DashboardPage() {
    //composition design pattern to include page components via constructor
    //It can be optimized by providing these components via dependency injection
    this.leftMenuComponent = new LeftMenuComponent();
    this.customersPage =  new CustomersPage();
  }

  public CustomersPage navigateToCustomersPage() {
    leftMenuComponent
      .openMainMenu("Customers")
      .openSubMenu("Customers", CustomersPage.class);
    return new CustomersPage();
  }

  public boolean isDashboardDisplayed() {
    return Actions.onElement(dashboardHeading).isDisplayed();
  }

}
