package com.itkhanz.nopcommerce.pages;

import com.itkhanz.nopcommerce.pages.components.submenus.LeftMenuComponent;
import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;

public class DashboardPage implements HasAlerts {

  private final LeftMenuComponent leftMenuComponent;
  private final AddNewCustomerPage addNewCustomerPage;

  public DashboardPage() {

    this.leftMenuComponent = new LeftMenuComponent();
    this.addNewCustomerPage = new AddNewCustomerPage();
  }

  public CustomersPage navigateCustomersPage() {
    leftMenuComponent
      .openMainMenu("Customers")
      .openSubMenu("Customers", CustomersPage.class);
    return new CustomersPage();
  }

}
