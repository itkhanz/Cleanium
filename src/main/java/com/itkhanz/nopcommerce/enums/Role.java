package com.itkhanz.nopcommerce.enums;

public enum Role {
  EDITOR("editor"),
  ADMIN("admin"),
  USER("user"),
  GUEST("guest");

  private final String name;

  Role(String role) {
    this.name = role;
  }

  public String getRole() {
    return name;
  }
}
