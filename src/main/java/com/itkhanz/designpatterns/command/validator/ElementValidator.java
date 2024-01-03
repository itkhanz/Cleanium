package com.itkhanz.designpatterns.command.validator;

public abstract class ElementValidator {
  public abstract boolean validate();

  public abstract String getMessage();
}