package com.itkhanz.nopcommerce.pages.components.submenus;

import com.itkhanz.core.element.actions.Actions;
import com.itkhanz.core.element.locator.LocatorBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class LeftMenuComponent {
  private static final String mainMenuLink = "//*[contains(text(), '%s')]/parent::a";
  private static final String subMenuLink = "//*[contains(text(), '%s')]/parent::a[@href='/Admin/Customer/List']";

  public LeftMenuComponent openMainMenu(String menu) {
    String menuXpath = LocatorBuilder.buildLocatorString(mainMenuLink,menu);
    Actions.onElement(By.xpath(menuXpath)).click();
    return this;
  }

  @SneakyThrows
  public <T> T openSubMenu(String subMenu, Class<T> cls) {
    String menuXpath = LocatorBuilder.buildLocatorString(subMenuLink,subMenu);
    Actions.onElement(By.xpath(menuXpath)).click();
    return cls.newInstance();
  }
}
