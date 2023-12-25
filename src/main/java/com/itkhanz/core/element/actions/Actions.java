package com.itkhanz.core.element.actions;

import com.itkhanz.core.element.actions.dropdown.DropdownActionsImpl;
import com.itkhanz.core.element.actions.webelement.ElementActionsImpl;
import org.openqa.selenium.By;

public interface Actions {

  static ElementActionsImpl onElement(By locator) {
    return new ElementActionsImpl(locator);
  }

  static DropdownActionsImpl onDropdown(By locator) {
    return new DropdownActionsImpl(locator);
  }
}
