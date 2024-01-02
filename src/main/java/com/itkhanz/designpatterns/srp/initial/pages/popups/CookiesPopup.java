package com.itkhanz.designpatterns.srp.initial.pages.popups;

import org.openqa.selenium.By;

public class CookiesPopup extends AbstractPopup{
  private static final By acceptBtn = By.xpath("//button//*[text()='Accept all' or text()='Alle akzeptieren']");
  private static final By rejectBtn = By.xpath("//button//*[text()='Reject all' or text()='Alle ablehnen']");


  @Override
  public void accept() {
    click(acceptBtn);
  }

  @Override
  public void dismiss() {
    click(rejectBtn);
  }
}
