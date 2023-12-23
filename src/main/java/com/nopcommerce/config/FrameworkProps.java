package com.nopcommerce.config;

public class FrameworkProps {
  private String baseURL;
  private String useremail;
  private String password;

  public FrameworkProps(String baseURL, String useremail, String password) {
    this.baseURL = baseURL;
    this.useremail = useremail;
    this.password = password;
  }

  public String getBaseURL() {
    return baseURL;
  }

  public String getUseremail() {
    return useremail;
  }

  public String getPassword() {
    return password;
  }
}
