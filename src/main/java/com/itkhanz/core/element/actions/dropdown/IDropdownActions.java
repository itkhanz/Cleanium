package com.itkhanz.core.element.actions.dropdown;

import com.itkhanz.core.element.wait.ElementWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface IDropdownActions {
  default Select getNativeSelect(By locator) {
    return new Select(WaitFactory.performExplicitWait(ElementWaitStrategy.CLICKABLE, WaitDuration.MEDIUM, locator));
  }

  List<WebElement> getOptions();
  List<WebElement> getAllSelectedOptions();
  WebElement getFirstSelectedOption();
  void selectByText(String text);
  void selectByValue(String value);
  void selectByIndex(int index);
  void deselectByText(String text);
  void deselectByValue(String value);
  void deselectByIndex(int index);


}
