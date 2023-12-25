package com.itkhanz.nopcommerce.pages;

import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;
import com.itkhanz.nopcommerce.pages.components.submenus.LeftMenuComponent;

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
