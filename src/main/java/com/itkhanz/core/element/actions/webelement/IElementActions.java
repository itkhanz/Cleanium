package com.itkhanz.core.element.actions.webelement;

public interface IElementActions {
  void click();
  void type(String text);
  void clear();
  String getText();
  String getAttribute(String attr);
  boolean isDisplayed();
  boolean isEnabled();
  boolean isSelected();

}
