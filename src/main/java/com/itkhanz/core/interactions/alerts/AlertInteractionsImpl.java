package com.itkhanz.core.interactions.alerts;

public class AlertInteractionsImpl implements IAlertInteractions, IConfirmActions, IPromptActions {

  @Override
  public String getText() {
    return getNativeAlert().getText();
  }

  @Override
  public void accept() {
    getNativeAlert().accept();
  }

  @Override
  public void dismiss() {
    getNativeAlert().dismiss();
  }

  @Override
  public void type(String text) {
    getNativeAlert().sendKeys(text);
  }
}
