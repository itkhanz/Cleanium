package com.itkhanz.nopcommerce.pages.components;

import com.itkhanz.core.element.actions.ElementActions;
import com.itkhanz.core.element.locator.XPathProvider;
import org.openqa.selenium.By;

public final class LeftMenuComponent {
  private String mainMenuLink = "//*[contains(text(), '%s')]/parent::a";
  private String subMenuLink = "//*[contains(text(), '%s')]/parent::a";

  public LeftMenuComponent openMainMenu(String menu) {
    String menuXpath = XPathProvider.createXPath(mainMenuLink,menu);
    ElementActions.click(By.xpath(menuXpath));
    return this;
  }

  public LeftMenuComponent openSubMenu(String menu) {
    String menuXpath = XPathProvider.createXPath(subMenuLink,menu);
    ElementActions.click(By.xpath(menuXpath));
    return this;
  }
}
