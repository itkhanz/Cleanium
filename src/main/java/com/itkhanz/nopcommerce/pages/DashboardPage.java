package com.itkhanz.nopcommerce.pages;

import com.itkhanz.nopcommerce.pages.components.LeftMenuComponent;

public class DashboardPage {
  private final LeftMenuComponent leftMenuComponent;

  public DashboardPage() {
    leftMenuComponent = new LeftMenuComponent();
  }

  public void navigateToAddCustomersPage() {
    leftMenuComponent.openMainMenu("Customers").openSubMenu("Customers");
  }
}
