package com.itkhanz.nopcommerce.pages;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.core.element.locator.utils.LocatorBuilder;
import com.itkhanz.nopcommerce.entities.CustomerData;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class AddNewCustomerPage {
  private static final String inputFieldXpath = "//label[text()='%s']/../../following-sibling::*//input";
  private static final String genderCheckboxId = "Gender_%s";
  private static final By saveBtn = By.xpath("//button[@name='save']");

  private AddNewCustomerPage setEmail(String email) {
    String elementXPath = LocatorBuilder.buildLocatorString(inputFieldXpath, "Email");
    Actions.onElement(By.xpath(elementXPath)).clickAndType(email);
    return this;
  }

  private AddNewCustomerPage setPassword(String password) {
    String elementXPath = LocatorBuilder.buildLocatorString(inputFieldXpath, "Password");
    Actions.onElement(By.xpath(elementXPath)).clickAndType(password);
    return this;
  }

  private AddNewCustomerPage setGender(String gender) {
    String elementID = LocatorBuilder.buildLocatorString(genderCheckboxId, StringUtils.capitalize(gender));
    Actions.onElement(By.id(elementID)).click();
    return this;
  }

  private void saveCustomer() {
    Actions.onElement(saveBtn).click();
  }

  public CustomersPage addNewCustomer(CustomerData customerData) {
    this
      .setEmail(customerData.getEmail())
      .setPassword(customerData.getPassword())
      .setGender(customerData.getGender())
      .saveCustomer();
    return new CustomersPage();
  }

}
