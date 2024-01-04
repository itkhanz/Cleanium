package com.itkhanz.designpatterns.proxy.enums;

public enum Environment {
  DEV("DEV"),
  QA("QA"),
  STAGING("STAGING"),
  PROD("PROD");

  private final String value;

  Environment(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
