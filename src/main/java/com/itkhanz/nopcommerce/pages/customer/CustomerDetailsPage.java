package com.itkhanz.nopcommerce.pages.customer;

import com.itkhanz.nopcommerce.entities.CustomerData;
import com.itkhanz.nopcommerce.pages.components.alerts.HasAlerts;

public class CustomerDetailsPage extends AbstractCustomerDetailsPage implements IFillCustomerDetails, HasAlerts {

  private CustomerDetailsPage(CustomerData customerData) {
    //we pass the customer data using constructor injection so the data is available to all the methods
    this.email = customerData.getEmail();
    this.password = customerData.getPassword();
    this.gender = customerData.getGender();
  }

  public static CustomerDetailsPage withCustomer(CustomerData customerData) {
    return new CustomerDetailsPage(customerData);
  }

  @Override
  public CustomersPage addNewCustomerWithMandatoryFields() {
    //use this method to fill the form with mandatory fields only e.g. email and password
      this
      .setEmail()
      .setPassword()
      .saveCustomer();
    return new CustomersPage();
  }

  @Override
  public CustomerDetailsPage addNewCustomerWithOptionalFields() {
    //Use this method to fill the form with optional fields and check for any errors
    this.setGender().saveCustomer();
    return this;
  }
}
