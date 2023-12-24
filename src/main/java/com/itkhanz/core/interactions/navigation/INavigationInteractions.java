package com.itkhanz.core.interactions.navigation;

public interface INavigationInteractions {
  void loadUrl(String url);
  void refresh();
  void navigateForward();
  void navigateBackward();
}
