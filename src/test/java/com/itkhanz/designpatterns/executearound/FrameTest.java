package com.itkhanz.designpatterns.executearound;

import com.itkhanz.designpatterns.BaseTest;
import com.itkhanz.designpatterns.executearound.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
  private MainPage mainPage;

  @BeforeMethod
  public void setMainPage(){
    this.mainPage = new MainPage(driver);
  }

  @Test
  public void frameTest(){
    this.mainPage.goTo();
    this.mainPage.onFrameA(a -> {
      a.setFirstName("fn1");
      a.setMessage("I am going to fill text area");
    });
    this.mainPage.onFrameC(c -> c.setAddress("address for FrameC"));
    this.mainPage.onFrameB(b -> b.setMessage("this is for Frame B"));
  }
}
