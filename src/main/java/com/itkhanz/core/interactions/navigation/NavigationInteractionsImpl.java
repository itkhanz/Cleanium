package com.itkhanz.core.interactions.navigation;

import com.itkhanz.core.driver.DriverManager;

public class NavigationInteractionsImpl implements INavigationInteractions {

  @Override
  public void loadUrl(String url) {
    DriverManager.getDriver().get(url);
  }

  @Override
  public void navigateForward() {
    DriverManager.getDriver().navigate().forward();
  }

  @Override
  public void navigateBackward() {
    DriverManager.getDriver().navigate().back();
  }

  @Override
  public void refresh() {
    DriverManager.getDriver().navigate().refresh();
  }
}
