package com.itkhanz.nopcommerce.pages;

import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;
import com.itkhanz.nopcommerce.pages.components.submenus.LeftMenuComponent;
import com.itkhanz.nopcommerce.pages.customer.CustomersPage;

public class DashboardPage implements HasAlerts {

  private final LeftMenuComponent leftMenuComponent;
  private final CustomersPage customersPage;

  public DashboardPage() {
    //composition design pattern to include page components via constructor
    //It can be optimized by providing these components via dependency injection
    this.leftMenuComponent = new LeftMenuComponent();
    this.customersPage =  new CustomersPage();
  }

  public CustomersPage navigateCustomersPage() {
    leftMenuComponent
      .openMainMenu("Customers")
      .openSubMenu("Customers", CustomersPage.class);
    return new CustomersPage();
  }

}
