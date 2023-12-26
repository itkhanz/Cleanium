package com.itkhanz.nopcommerce.pages.customer;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.core.element.locator.utils.LocatorBuilder;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public abstract class AbstractCustomerDetailsPage {
  protected String email;
  protected String password;
  protected String gender;

  private static final String inputFieldXpath = "//label[text()='%s']/../../following-sibling::*//input";
  private static final String genderCheckboxId = "Gender_%s";
  private static final By saveBtn = By.xpath("//button[@name='save']");

  protected AbstractCustomerDetailsPage setEmail() {
    String elementXPath = LocatorBuilder.buildLocatorString(inputFieldXpath, "Email");
    Actions.onElement(By.xpath(elementXPath)).clickAndType(email);
    return this;
  }

  protected AbstractCustomerDetailsPage setPassword() {
    String elementXPath = LocatorBuilder.buildLocatorString(inputFieldXpath, "Password");
    Actions.onElement(By.xpath(elementXPath)).clickAndType(password);
    return this;
  }

  protected AbstractCustomerDetailsPage setGender() {
    String elementID = LocatorBuilder.buildLocatorString(genderCheckboxId, StringUtils.capitalize(gender));
    Actions.onElement(By.id(elementID)).click();
    return this;
  }

  protected void saveCustomer() {
    Actions.onElement(saveBtn).click();
  }

  public CustomersPage addNewCustomer() {
    this
      .setEmail()
      .setPassword()
      .setGender()
      .saveCustomer();
    return new CustomersPage();
  }

}
