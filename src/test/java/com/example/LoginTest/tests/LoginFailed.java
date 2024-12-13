package com.example.LoginTest.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginFailed {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "//Users/amadoutaal/Downloads/chromedriver-mac-arm64/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testFail() throws Exception {
    driver.get("https://letsusedata.com/index.html");
    driver.findElement(By.id("txtUser")).click();
    driver.findElement(By.id("txtUser")).clear();
    driver.findElement(By.id("txtUser")).sendKeys("s-amadou.taal@lwtech.edu");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("vMjpoLD{6;");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Theme'])[1]/following::div[7]")).click();
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("password");
    driver.findElement(By.id("javascriptLogin")).click();
    driver.findElement(By.xpath("//span[@id='lblMessage']")).getText();//this tests if there is a span element with the value "Password was incorrect"
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
