package com.itkhanz.designpatterns.srp.initial.pages.popups;

import com.itkhanz.designpatterns.srp.initial.pages.BasePage;

public abstract class AbstractPopup extends BasePage {
  abstract void accept();

  abstract void dismiss();

}
