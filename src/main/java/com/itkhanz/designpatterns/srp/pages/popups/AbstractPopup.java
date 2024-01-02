package com.itkhanz.designpatterns.srp.pages.popups;

import com.itkhanz.designpatterns.srp.pages.BasePage;

public abstract class AbstractPopup extends BasePage {
  abstract void accept();

  abstract void dismiss();

}
