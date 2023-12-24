package com.itkhanz.core.interactions;

import com.itkhanz.core.interactions.actions.KeyboardActionsImpl;
import com.itkhanz.core.interactions.actions.MouseActionsImpl;
import com.itkhanz.core.interactions.alerts.AlertInteractionsImpl;
import com.itkhanz.core.interactions.frames.FrameInteractionsImpl;
import com.itkhanz.core.interactions.windows.WindowInteractionsImpl;
import com.itkhanz.core.interactions.navigation.NavigationInteractionsImpl;

public interface Interactions {
  static NavigationInteractionsImpl navigation() {
    return new NavigationInteractionsImpl();
  }

  static AlertInteractionsImpl alerts() {
    return new AlertInteractionsImpl();
  }

  static FrameInteractionsImpl frames() {
    return new FrameInteractionsImpl();
  }

  static WindowInteractionsImpl windows() {
    return new WindowInteractionsImpl();
  }

  static KeyboardActionsImpl keyboard() {
    return new KeyboardActionsImpl();
  }

  static MouseActionsImpl mouse() {
    return new MouseActionsImpl();
  }

}
