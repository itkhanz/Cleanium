package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.core.element.locator.utils.LocatorBuilder;
import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;
import org.openqa.selenium.By;

public class CustomersPage implements HasAlerts {
  private static final String addCustomerBtn = "//a[normalize-space()='%s']";

  public AddNewCustomerPage navigateToAddNewCustomerPage() {
    String btnXpath = LocatorBuilder.buildLocatorString(addCustomerBtn, "Add new");
    Actions.onElement(By.xpath(btnXpath)).click();
    return new AddNewCustomerPage();
  }

}
